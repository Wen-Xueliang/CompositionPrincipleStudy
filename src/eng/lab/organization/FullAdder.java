package eng.lab.organization;

import static eng.lab.organization.BasicLogicGate.*;

/**
 * @Author: Wen-Xueliang
 * @Date: Created in 2019/11/4 22:05
 * @Description: 全加器
 */
public class FullAdder implements Mechanical {
    int A;
    int B;
    int C;

    int sum;
    int carry;

    HalfAdder halfAdderA;
    HalfAdder halfAdderB;

    public FullAdder(int A, int B, int C) {
        this.A = A;
        this.B = B;
        this.C = C;
        generateDataOutPut();
    }

    @Override
    public void generateDataOutPut() {
        halfAdderA = new HalfAdder(A, B);
        halfAdderB = new HalfAdder(halfAdderA.sum, C);

        carry = or(halfAdderA.carry, halfAdderB.carry);
        sum = halfAdderB.sum;
    }

    @Override
    public void print() {
        System.out.println("carry:" + carry + ", sum:" + sum);
    }
}
