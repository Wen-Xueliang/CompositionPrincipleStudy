package eng.lab.organization;

/**
 * @Author: Wen-Xueliang
 * @Date: Created in 2019/11/6 20:39
 * @Description:
 */
public class Register {

    GateLatch[] gateLatches = new GateLatch[8];

    int[] dataInput;
    int writeEnable;

    public Register() {
        for(int i = 0; i < gateLatches.length; i ++) {
            gateLatches[i] = new GateLatch();
        }
    }

    public void setData(int[] dataInput, int writeEnable) {
        this.dataInput = dataInput;
        this.writeEnable = writeEnable;
        for(int i = 0;i < gateLatches.length; i ++) {
            gateLatches[i].setData(dataInput[i], writeEnable);
        }
    }

    public void setDataInput(int[] dataInput) {
        setData(dataInput, writeEnable);
    }

    public void setWriteEnable(int writeEnable) {
        setData(dataInput, writeEnable);
    }

    public int[] getData() {
        int[] data = new int[gateLatches.length];
        for(int i = 0;i < gateLatches.length; i ++) {
            data[i] = gateLatches[i].getData();
        }
        return data;
    }
}
