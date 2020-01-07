package eng.lab.organization;

/**
 * @Author: Wen-Xueliang
 * @Date: Created in 2019/11/6 20:35
 * @Description:
 */
public class CPU {

    ALU alu = new ALU();
    CU cu = new CU();
    Register registerA = new Register();
    Register registerB = new Register();
    Register registerC = new Register();
    Register registerD = new Register();

    int[] data;
    int[] addressInput;
    int readEnable;
    int writeEnable;

    public void start(RAM ram) {
        while(true) {
            cu.fetchPhase(ram, alu, registerA, registerB, registerC, registerD);
        }
    }
}
