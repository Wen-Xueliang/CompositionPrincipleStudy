package eng.lab.organization;

/**
 * @Author: Wen-Xueliang
 * @Date: Created in 2019/11/4 22:47
 * @Description: 门锁矩阵
 */
public class LatchMatrix {

    LatchMatrixUnit[][] matrix = new LatchMatrixUnit[16][16];

    Multiplexer columnMultiplexer = new Multiplexer();
    Multiplexer rowMultiplexer = new Multiplexer();

    public LatchMatrix() {
        for(int i = 0; i < matrix.length; i ++) {
            LatchMatrixUnit[] row = matrix[i];
            for(int j = 0; j < row.length; j ++) {
                LatchMatrixUnit latchMatrixUnit = new LatchMatrixUnit();
                latchMatrixUnit.setIndex(i, j);
                matrix[i][j] = latchMatrixUnit;
            }
        }
    }

    public void setData(int[] addressInput, int dataInput, int writeEnable) {
        LatchMatrixUnit latchMatrixUnit = selectLatchMatrixUnit(addressInput);
        latchMatrixUnit.setData(dataInput, writeEnable);
    }

    public int getData(int[] addressInput, int readEnable) {
        LatchMatrixUnit latchMatrixUnit = selectLatchMatrixUnit(addressInput);
        return latchMatrixUnit.getData(readEnable);
    }

    public LatchMatrixUnit selectLatchMatrixUnit(int[] addressInput) {
        int[] rowAdress = new int[addressInput.length / 2];
        int[] columnAdress = new int[addressInput.length / 2];
        for(int i = 0; i < addressInput.length; i++) {
            if(i < addressInput.length / 2) {
                rowAdress[i] = addressInput[i];
            } else {
                columnAdress[i - (addressInput.length / 2)] = addressInput[i];
            }
        }
        int row = rowMultiplexer.generateData(rowAdress);
        int column = columnMultiplexer.generateData(columnAdress);
        return matrix[row][column];
    }
}
