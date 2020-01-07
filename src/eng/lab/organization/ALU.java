package eng.lab.organization;

import static eng.lab.organization.BasicLogicGate.and;
import static eng.lab.organization.BasicLogicGate.not;

/**
 * @Author: Wen-Xueliang
 * @Date: Created in 2019/11/6 19:54
 * @Description:
 */
public class ALU implements Mechanical {

    int[] dataInputA;
    int[] dataInputB;

    int[] operationCode;
    int[] dataOutput;

    int overflowFlag;
    int zeroFlag;
    int negativeFlag;

    int checkIfAdd;

    Adder adder;
    ZeroChecker zeroChecker;

    public void setDataInputA(int[] dataInputA) {
        this.dataInputA = dataInputA;
    }

    public void setDataInputB(int[] dataInputB) {
        this.dataInputB = dataInputB;
    }

    public void setOperationCode(int[] operationCode) {
        this.operationCode = operationCode;
    }

    public void setDataInput(int[] dataInputA, int[] dataInputB) {
        setDataInputA(dataInputA);
        setDataInputB(dataInputB);
    }

    public void setDataInput(int[] operationCode, int[] dataInputA, int[] dataInputB) {
        setOperationCode(operationCode);
        setDataInput(dataInputA, dataInputB);
    }

    @Override
    public void generateDataOutPut() {
        checkIfAdd = and(and(operationCode[0], not(operationCode[1])), and(not(operationCode[2]), not(operationCode[3])));//1000

        adder = new Adder(dataInputA, dataInputB);
        dataOutput = adder.result;

        zeroChecker = new ZeroChecker();
        zeroChecker.setDataInput(dataOutput);
        zeroFlag = zeroChecker.out;
        overflowFlag = and(adder.carry, checkIfAdd);
    }

    @Override
    public void print() {

    }
}
