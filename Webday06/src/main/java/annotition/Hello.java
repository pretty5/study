package annotition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
//设置注解的保留方式：RUNTIME:表示在运行时可以获取或者使用注解
@Retention(RetentionPolicy.RUNTIME)
public @interface Hello {
    //表示注解的一个字段  字段的类型是String
    String value();
    String time();
}
