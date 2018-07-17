package exception;

import javax.print.attribute.standard.NumberUp;
import java.io.IOException;
import java.lang.instrument.IllegalClassFormatException;

/*
*@ClassName:ThrowTest
 @Description:TODO
 @Author:
 @Date:2018/7/17 15:05 
 @Version:v1.0
*/
//处理异常的第二种方式:不处理（抛出）
/*
       出现runtimeException说明代码有问题。应该去修改代码，不应去try catch  throw

 */
public class ThrowTest {
    public static void main(String[] args) throws Exception {
        ThrowTest throwTest = new ThrowTest();
        /*try {
            throwTest.f1(0);
        } catch (Exception e) {
            e.printStackTrace();

        }*/
        /*int score=59;

        if (score<60){
            try {
                throw new ScoreException("不及格",score);
            } catch (ScoreException e) {
                e.printStackTrace();
            }

        }*/

            throwTest.f1(1);
            throwTest.f2(3);



    }
    public void f1(int num) throws IOException {
        if (num<=0){
            throw new IOException("num < 0");
        }
        System.out.println("num is :"+num);
    }
    public void f2(int num) throws IllegalClassFormatException {
        if (num<=0){
            throw new IllegalClassFormatException("num < 0");
        }
        System.out.println("num is :"+num);
    }



    public void isNull(String s){
        if (s==null){
            throw new NullPointerException();
        }
    }


}
