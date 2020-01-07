package eng.lab.organization;

/**
 * @Author: Wen-Xueliang
 * @Date: Created in 2019/11/5 22:06
 * @Description:
 */
public class RAM {

    LatchMatrix[] latchMatrices = new LatchMatrix[8];

    public RAM() {
        for(int i = 0; i < latchMatrices.length; i ++) {
            latchMatrices[i] = new LatchMatrix();
        }
    }

    public int[] getData(int[] addressInput, int readEnable) {
        int[] data = new int[latchMatrices.length];
        for(int i = 0; i < latchMatrices.length; i ++) {
            data[i] = latchMatrices[i].getData(addressInput, readEnable);
        }
        return data;
    }

    public void setData(int[] addressInput, int[] dataInput, int writeEnable) {
        for(int i = 0; i < latchMatrices.length; i ++) {
            latchMatrices[i].setData(addressInput, dataInput[i], writeEnable);
        }
    }
}
