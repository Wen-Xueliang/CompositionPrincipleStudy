package eng.lab.organization;

import static eng.lab.organization.BasicLogicGate.*;

/**
 * @Author: Wen-Xueliang
 * @Date: Created in 2019/11/6 22:21
 * @Description:
 */
public class CU{

    Register instructionRegister = new Register();
    Register instructionAddressRegister = new Register();

    Register tempRegister = new Register();

    int checkIfLoadA;
    int checkIfLoadB;
    int checkIfStoreA;
    int checkIfAdd;

    public CU() {
        int[] initData = {0,0,0,0,0,0,0,0};
        instructionAddressRegister.setData(initData, 1);
    }

    public void fetchPhase(RAM ram, ALU alu, Register registerA, Register registerB, Register registerC, Register registerD) {
        int[] data = ram.getData(instructionAddressRegister.getData(), 1);
        instructionRegister.setData(data, 1);

        decodePhase(ram, alu, registerA, registerB, registerC, registerD);
    }

    private void decodePhase(RAM ram, ALU alu, Register registerA, Register registerB, Register registerC, Register registerD) {
        int[] instructionRegisterData = instructionRegister.getData();
        int[] opCode = new int[instructionRegisterData.length / 2];
        int[] opData = new int[instructionRegisterData.length / 2];
        for(int i = 0; i < instructionRegisterData.length; i++) {
            if(i < instructionRegisterData.length / 2) {
                opCode[i] = instructionRegisterData[i];
            } else {
                opData[i - (instructionRegisterData.length / 2)] = instructionRegisterData[i];
            }
        }
        checkIfLoadA = and(and(not(opCode[0]), not(opCode[1])), and(opCode[2], not(opCode[3])));//0010
        checkIfLoadB = and(and(not(opCode[0]), not(opCode[1])), and(not(opCode[2]), opCode[3]));//0001
        checkIfStoreA = and(and(not(opCode[0]), opCode[1]), and(not(opCode[2]), not(opCode[3])));//0100
        checkIfAdd = and(and(opCode[0], not(opCode[1])), and(not(opCode[2]), not(opCode[3])));//1000

        executePhase(ram, alu, opData, registerA, registerB, registerC, registerD);
    }

    private void executePhase(RAM ram, ALU alu, int[] opData, Register registerA, Register registerB, Register registerC, Register registerD) {
        int readEnable = (checkIfLoadA == 1 || checkIfLoadB == 1) ? 1 : 0;
        int[] address = new int[8];
        for(int i = 0; i < opData.length; i ++) {
            address[i + (address.length - opData.length)] = opData[i];
        }
        int[] ramData = ram.getData(address, readEnable);
        registerA.setData(ramData, checkIfLoadA);
        registerB.setData(ramData, checkIfLoadB);

        int[] registerOne = new int[opData.length / 2];
        int[] registerTwo = new int[opData.length / 2];
        for(int i = 0; i < opData.length; i++) {
            if(i < opData.length / 2) {
                registerOne[i] = opData[i];
            } else {
                registerTwo[i - (opData.length / 2)] = opData[i];
            }
        }

        int[] dataOne = getDataByCode(registerOne, registerA, registerB, registerC, registerD);
        int[] dataTwo = getDataByCode(registerTwo, registerA, registerB, registerC, registerD);
        int[] operationCode = {1, 0, 0, 0};
        alu.setDataInput(operationCode, dataOne, dataTwo);
        alu.generateDataOutPut();
        tempRegister.setData(alu.dataOutput, checkIfAdd);

        int[] temp = tempRegister.getData();
        registerA.setData(temp, checkIfStoreA);


        plusOne(ram, alu, registerA, registerB, registerC, registerD);
    }

    public int[] getDataByCode(int[] code, Register registerA, Register registerB, Register registerC, Register registerD) {
        int hitRegitsterA = and(not(code[0]), not(code[1]));
        int hitRegitsterB = and(not(code[0]), code[1]);
        int hitRegitsterC = and(code[0], not(code[1]));
        int hitRegitsterD = and(code[0], code[1]);

        if(hitRegitsterA == 1) return registerA.getData();
        if(hitRegitsterB == 1) return registerB.getData();
        if(hitRegitsterC == 1) return registerC.getData();
        if(hitRegitsterD == 1) return registerD.getData();
        return null;
    }

    private void plusOne(RAM ram, ALU alu, Register registerA, Register registerB, Register registerC, Register registerD) {
        int[] operationCode = {1, 0, 0, 0};
        int[] dataInputA = {0, 0, 0, 0, 0, 0, 0, 1};
        alu.setDataInput(operationCode, dataInputA, instructionAddressRegister.getData());
        alu.generateDataOutPut();
        instructionAddressRegister.setData(alu.dataOutput, 1);

        fetchPhase(ram, alu, registerA, registerB, registerC, registerD);
    }
}
