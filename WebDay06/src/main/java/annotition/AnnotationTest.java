package annotition;

import javax.swing.text.html.HTML;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/*
*@ClassName:AnnotationTest
 @Description:TODO
 @Author:
 @Date:2018/8/20 16:08 
 @Version:v1.0
*/
/*
    使用注解，只需要将注解写在 类名 方法名 字段名的上面。注解名前加@
    获取注解：用反射

 */
@Hello(value = "223",time = "2018")
public class AnnotationTest {
    @Hello(value = "456",time = "2017")
    public void anno1(){

    }
    @Hello(value = "789",time = "")
    private String name;

    public static void main(String[] args) throws NoSuchMethodException {
        //获取类上的注解
        //test1();
        //获取方法上的注解
        test2();

    }

    private static void test2() throws NoSuchMethodException {
        Method method = AnnotationTest.class.getDeclaredMethod("anno1");
        //获取方法上的注解
        Hello annotation = method.getAnnotation(Hello.class);

        System.out.println(annotation.value());

        System.out.println(annotation.time());

    }

    private static void test1() {
        //获取类上声明的注解
        Annotation[] annotations = AnnotationTest.class.getAnnotations();
        for (Annotation anno:
             annotations) {
            //没有限定类型的注解
            System.out.println(anno.toString());
        }
        //限定类型的注解
        Hello annotation = AnnotationTest.class.getDeclaredAnnotation(Hello.class);

        System.out.println(annotation.value());

        System.out.println(annotation.time());;

    }
}
