package eng.lab.organization;

import static eng.lab.organization.BasicLogicGate.*;

/**
 * @Author: Wen-Xueliang
 * @Date: Created in 2019/11/4 22:40
 * @Description: 门锁存器
 */
public class GateLatch {
    int dataInput;
    int writeEnable;
    int dataOutput;

    public void setData(int dataInput, int writeEnable) {
        this.dataInput = dataInput;
        this.writeEnable = writeEnable;
        getData();
    }

    public void setDataInput(int dataInput) {
        this.dataInput = dataInput;
    }

    public void setWriteEnable(int writeEnable) {
        this.writeEnable = writeEnable;
    }

    public int getData() {
        dataOutput = and(or(and(dataInput, writeEnable), dataOutput), not(and(not(dataInput), writeEnable)));
        return dataOutput;
    }
}
