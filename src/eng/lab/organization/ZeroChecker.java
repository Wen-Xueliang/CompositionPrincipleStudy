package eng.lab.organization;

import static eng.lab.organization.BasicLogicGate.*;

/**
 * @Author: Wen-Xueliang
 * @Date: Created in 2019/11/6 20:02
 * @Description:
 */
public class ZeroChecker implements Mechanical {


    int[] dataInput;
    int out;

    public void setDataInput(int[] dataInput) {
        this.dataInput = dataInput;
        generateDataOutPut();
    }

    @Override
    public void generateDataOutPut() {
        out = not(or(or(or(dataInput[0], dataInput[1]),or(dataInput[2], dataInput[3])),
        or(or(dataInput[4], dataInput[5]),or(dataInput[6], dataInput[7]))));

        /*for(int i = 0; i < dataInput.length; i = i + 2) {
            out = or(dataInput[i], dataInput[i + 1]);
        }*/
    }

    @Override
    public void print() {
        System.out.println("out:" + out);
    }
}
