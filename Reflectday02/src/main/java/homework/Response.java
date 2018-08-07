package homework;

import java.io.Serializable;

/*
*@ClassName:Response
 @Description:TODO
 @Author:
 @Date:2018/8/7 10:02 
 @Version:v1.0
*/
//服务端给客户端的响应
public class Response implements Serializable {
    //表示服务端方法的返回值
    private Object result;
    //表示调用的成功与否
    private String msg;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Response{" +
                "result=" + result +
                ", msg='" + msg + '\'' +
                '}';
    }
}
