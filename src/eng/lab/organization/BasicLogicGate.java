package eng.lab.organization;

/**
 * @Author: Wen-Xueliang
 * @Date: Created in 2019/11/4 21:46
 * @Description: 基础逻辑门
 */
public class BasicLogicGate {
    static int and(int A, int B) {
        return A & B;
    }
    static int or(int A, int B) {
        return A | B;
    }
    static int not(int A) {
        return (A == 0)?1:0;
    }
    static int xor(int A, int B) {
        int orOut = or(A,B);
        int andNotOut = not(and(A,B));
        return and(orOut, andNotOut);
    }
}
