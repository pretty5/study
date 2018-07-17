package exception;

/*
*@ClassName:Exception1
 @Description:TODO
 @Author:
 @Date:2018/7/17 14:21 
 @Version:v1.0
*/
/*
 如果出现异常不处理。jvm会抛出此异常，程序终止。
 当代码出现异常的时候，如果有try catch,代码会跳转到catch 代码块中执行
 出现异常位置下面的不会执行。
 当异常处理结束以后，代码仍然按照先后次序执行。
 finally是异常处理中可选项。无论异常是否被备捕获，finally最终都会执行。

 */
public class Exception1 {

    public static void main(String[] args) {
        //在java中使用try catch语句进行异常的处理
        try {
            System.out.println(1 / 0);
            //System.out.println("below exception");
            String s = null;
            System.out.println(s.length());
        } catch (ArithmeticException e) {
            //打印异常栈
            //e.printStackTrace();
            System.out.println("catch1");
        } catch (Exception e) {
            System.out.println("catch2");
        } finally {
            //System.out.println("go to finally");
        }

        //System.out.println("after exception");
        //System.out.println(1/0);


    }

}
