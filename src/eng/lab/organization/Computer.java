package eng.lab.organization;

/**
 * @Author: Wen-Xueliang
 * @Date: Created in 2019/11/7 20:41
 * @Description:
 */
public class Computer {
    CPU cpu = new CPU();
    RAM ram = new RAM();

    public Computer() {
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public void runProgram1() {
        initRAM();
        cpu.start(ram);
    }

    private void initRAM() {
        int writeEnable = 1;
        int[] addressInput1 = {0,0,0,0,0,0,0,0};
        int[] dataInput1 = {0,0,1,0,1,1,1,0};
        int[] addressInput2 = {0,0,0,0,0,0,0,1};
        int[] dataInput2 = {0,0,0,1,1,1,1,1};
        int[] addressInput3 = {0,0,0,0,0,0,1,0};
        int[] dataInput3 = {1,0,0,0,0,1,0,0};
        int[] addressInput4 = {0,0,0,0,0,0,1,1};
        int[] dataInput4 = {0,1,0,0,1,1,0,1};
        int[] addressInput5 = {0,0,0,0,0,1,0,0};
        int[] dataInput5 = {0,0,0,0,0,0,0,0};
        int[] addressInput6 = {0,0,0,0,0,1,0,1};
        int[] dataInput6 = {0,0,0,0,0,0,0,0};
        int[] addressInput7 = {0,0,0,0,0,1,1,0};
        int[] dataInput7 = {0,0,0,0,0,0,0,0};
        int[] addressInput8 = {0,0,0,0,0,1,1,1};
        int[] dataInput8 = {0,0,0,0,0,0,0,0};
        int[] addressInput9 = {0,0,0,0,1,0,0,0};
        int[] dataInput9 = {0,0,0,0,0,0,0,0};
        int[] addressInput10 = {0,0,0,0,1,0,0,1};
        int[] dataInput10 = {0,0,0,0,0,0,0,0};
        int[] addressInput11 = {0,0,0,0,1,0,1,0};
        int[] dataInput11 = {0,0,0,0,0,0,0,0};
        int[] addressInput12 = {0,0,0,0,1,0,1,1};
        int[] dataInput12 = {0,0,0,0,0,0,0,0};
        int[] addressInput13 = {0,0,0,0,1,1,0,0};
        int[] dataInput13 = {0,0,0,0,0,0,0,0};
        int[] addressInput14 = {0,0,0,0,1,1,0,1};
        int[] dataInput14 = {0,0,0,0,0,0,0,0};
        int[] addressInput15 = {0,0,0,0,1,1,1,0};
        int[] dataInput15 = {0,0,0,0,0,0,1,1};
        int[] addressInput16 = {0,0,0,0,1,1,1,1};
        int[] dataInput16 = {0,0,0,0,1,1,1,0};

        ram.setData(addressInput1, dataInput1, writeEnable);
        ram.setData(addressInput2, dataInput2, writeEnable);
        ram.setData(addressInput3, dataInput3, writeEnable);
        ram.setData(addressInput4, dataInput4, writeEnable);
        ram.setData(addressInput5, dataInput5, writeEnable);
        ram.setData(addressInput6, dataInput6, writeEnable);
        ram.setData(addressInput7, dataInput7, writeEnable);
        ram.setData(addressInput8, dataInput8, writeEnable);
        ram.setData(addressInput9, dataInput9, writeEnable);
        ram.setData(addressInput10, dataInput10, writeEnable);
        ram.setData(addressInput11, dataInput11, writeEnable);
        ram.setData(addressInput12, dataInput12, writeEnable);
        ram.setData(addressInput13, dataInput13, writeEnable);
        ram.setData(addressInput14, dataInput14, writeEnable);
        ram.setData(addressInput15, dataInput15, writeEnable);
        ram.setData(addressInput16, dataInput16, writeEnable);
    }

    public int[] revert(int[] data) {
        int[] dataOutput = new int[data.length];
        for(int i = 0;i < data.length; i++) {
            dataOutput[i] = data[data.length - 1 - i];
        }
        return dataOutput;
    }
}
