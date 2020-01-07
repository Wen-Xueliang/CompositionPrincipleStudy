package eng.lab.organization;

import static eng.lab.organization.BasicLogicGate.*;

/**
 * @Author: Wen-Xueliang
 * @Date: Created in 2019/11/4 22:43
 * @Description: 门锁矩阵单元
 */
public class LatchMatrixUnit {
    int rowIndex;
    int columnIndex;

    int dataInput;
    int writeEnable;
    int readEnable;

    GateLatch gateLatch = new GateLatch();

    public void setData(int dataInput, int writeEnable) {
        this.writeEnable = writeEnable;
        this.dataInput = dataInput;
        gateLatch.setData(dataInput, writeEnable);
    }

    public void setDataInput(int dataInput) {
        setData(dataInput, writeEnable);
    }

    public void setWriteEnable(int writeEnable) {
        setData(dataInput, writeEnable);
    }

    public int getData() {
        return and(readEnable, gateLatch.getData());
    }

    public int getData(int readEnable) {
        return and(readEnable, gateLatch.getData());
    }

    public void setIndex(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }
}
