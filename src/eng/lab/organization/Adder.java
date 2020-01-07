package eng.lab.organization;

/**
 * @Author: Wen-Xueliang
 * @Date: Created in 2019/11/5 21:30
 * @Description: 加法器
 */
public class Adder {

    int[] result = new int[8];
    int carry;

    public Adder(int[] dataA, int[] dataB) {
        HalfAdder halfAdder = new HalfAdder(dataA[7], dataB[7]);
        FullAdder fullAdderA = new FullAdder(halfAdder.carry, dataA[6], dataB[6]);
        FullAdder fullAdderB = new FullAdder(fullAdderA.carry, dataA[5], dataB[5]);
        FullAdder fullAdderC = new FullAdder(fullAdderB.carry, dataA[4], dataB[4]);
        FullAdder fullAdderD = new FullAdder(fullAdderC.carry, dataA[3], dataB[3]);
        FullAdder fullAdderE = new FullAdder(fullAdderD.carry, dataA[2], dataB[2]);
        FullAdder fullAdderF = new FullAdder(fullAdderE.carry, dataA[1], dataB[1]);
        FullAdder fullAdderG = new FullAdder(fullAdderF.carry, dataA[0], dataB[0]);

        result[7] = halfAdder.sum;
        result[6] = fullAdderA.sum;
        result[5] = fullAdderB.sum;
        result[4] = fullAdderC.sum;
        result[3] = fullAdderD.sum;
        result[2] = fullAdderE.sum;
        result[1] = fullAdderF.sum;
        result[0] = fullAdderG.sum;
        carry = fullAdderG.carry;
    }
}
