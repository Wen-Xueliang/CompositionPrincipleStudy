package eng.lab.organization;

import static eng.lab.organization.BasicLogicGate.*;

/**
 * @Author: Wen-Xueliang
 * @Date: Created in 2019/11/4 22:38
 * @Description: And-Or锁存器
 */
public class AndOrLatch implements Mechanical {
    int set;
    int reset;

    int out;

    public void set(int set) {
        this.set = set;
        generateDataOutPut();
    }

    public void reset(int reset) {
        this.reset = reset;
        generateDataOutPut();
    }

    @Override
    public void generateDataOutPut() {
        out = and(or(set, out), not(reset));
    }

    @Override
    public void print() {
        System.out.println("out:" + out);
    }
}
