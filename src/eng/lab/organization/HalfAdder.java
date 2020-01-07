package eng.lab.organization;

import static eng.lab.organization.BasicLogicGate.*;

/**
 * @Author: Wen-Xueliang
 * @Date: Created in 2019/11/4 21:50
 * @Description: 半加器
 */
public class HalfAdder implements Mechanical{
    int A;
    int B;

    int sum;
    int carry;

    public HalfAdder(int A, int B) {
        this.A = A;
        this.B = B;
        generateDataOutPut();
    }

    @Override
    public void generateDataOutPut() {
        sum = xor(A, B);
        carry = and(A, B);
    }

    @Override
    public void print() {
        System.out.println("carry:" + carry + ", sum:" + sum);
    }
}
