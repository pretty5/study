package homework;

import java.io.Serializable;

/*
*@ClassName:Request
 @Description:TODO
 @Author:
 @Date:2018/8/7 9:45 
 @Version:v1.0
*/
//用来封装请求
public class Request implements Serializable {
    String methodName;//方法名
    Object[] params;//方法参数列表。

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
