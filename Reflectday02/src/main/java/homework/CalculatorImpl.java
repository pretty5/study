package homework;

/*
*@ClassName:CalculatorImpl
 @Description:TODO
 @Author:
 @Date:2018/8/7 9:22 
 @Version:v1.0
*/

public class CalculatorImpl implements Calculator {
    public int add(int p1, int p2) {
        return p1 + p2;
    }

    public int minus(int p1, int p2) {
        return p1 - p2;
    }

    public int mul(int p1, int p2) {
        return p1 * p2;
    }

    public int square(int p1) {
        return p1 * p1;
    }

    public int addx(int p1, int p2, int p3) {
        return p1 + p2 + p3;
    }
}
