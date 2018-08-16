package homework.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
*@ClassName:LogTest
 @Description:TODO
 @Author:
 @Date:2018/8/15 9:13 
 @Version:v1.0
*/
/*
    在java中有许多的日志记录框架（工具）
    如：java.util.logging,commons logging,log4j,logback
    slf4j:simple log facade for java:简单日志门面
    slf4j不是日志的具体实现，它类似一个接口的作用，当使用slf4j时，slf4j会根据当前项目中
    使用的日志框架进行调整。
    好处在于：在不修改源代码的基础上，可以更换，或者兼容不同的日志框架。

 */
public class LogTest {
    private static final Logger log = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        log.info("abc{}",1);
        log.error("abc{}",1);
        log.debug("abc{}",1);
        log.warn("abc{}",1);
        //判断当前日志级别
        boolean infoEnabled = log.isInfoEnabled();

        if (log.isInfoEnabled()){
            log.info("abc{}",1);
        }
        System.out.println(infoEnabled);

    }


}
