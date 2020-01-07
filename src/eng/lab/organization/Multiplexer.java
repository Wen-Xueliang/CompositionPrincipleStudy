package eng.lab.organization;

import static eng.lab.organization.BasicLogicGate.*;

/**
 * @Author: Wen-Xueliang
 * @Date: Created in 2019/11/5 21:48
 * @Description: 4-16路复用器
 */
public class Multiplexer {

    public int generateData(int[] dataInput) {
        int highLightIndex = 0;
        int[] dataOutput = new int[16];
        int dataInput0 = dataInput[0];
        int dataInput1 = dataInput[1];
        int dataInput2 = dataInput[2];
        int dataInput3 = dataInput[3];
        dataOutput[15] = and(and(dataInput0,dataInput1),and(dataInput2, dataInput3));
        dataOutput[14] = and(and(dataInput0,dataInput1),and(dataInput2, not(dataInput3)));
        dataOutput[13] = and(and(dataInput0,dataInput1),and(not(dataInput2), dataInput3));
        dataOutput[12] = and(and(dataInput0,dataInput1),and(not(dataInput2), not(dataInput3)));
        dataOutput[11] = and(and(dataInput0,not(dataInput1)),and(dataInput2, dataInput3));
        dataOutput[10] = and(and(dataInput0,not(dataInput1)),and(dataInput2, not(dataInput3)));
        dataOutput[9] = and(and(dataInput0,not(dataInput1)),and(not(dataInput2), dataInput3));
        dataOutput[8] = and(and(dataInput0,not(dataInput1)),and(not(dataInput2), not(dataInput3)));
        dataOutput[7] = and(and(not(dataInput0),dataInput1),and(dataInput2, dataInput3));
        dataOutput[6] = and(and(not(dataInput0),dataInput1),and(dataInput2, not(dataInput3)));
        dataOutput[5] = and(and(not(dataInput0),dataInput1),and(not(dataInput2), dataInput3));
        dataOutput[4] = and(and(not(dataInput0),dataInput1),and(not(dataInput2), not(dataInput3)));
        dataOutput[3] = and(and(not(dataInput0),not(dataInput1)),and(dataInput2, dataInput3));
        dataOutput[2] = and(and(not(dataInput0),not(dataInput1)),and(dataInput2, not(dataInput3)));
        dataOutput[1] = and(and(not(dataInput0),not(dataInput1)),and(not(dataInput2), dataInput3));
        dataOutput[0] = and(and(not(dataInput0),not(dataInput1)),and(not(dataInput2), not(dataInput3)));

        for(int i = 0; i < dataOutput.length; i ++) {
            if(dataOutput[i] == 1) {
                highLightIndex = i;
            }
        }
        return highLightIndex;
    }
}
