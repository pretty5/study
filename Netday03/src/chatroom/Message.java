package chatroom;

import java.io.Serializable;

/*
*@ClassName:Message
 @Description:TODO
 @Author:
 @Date:2018/8/1 16:37 
 @Version:v1.0
*/
//实现序列化接口，可以被网络传输
public class Message implements Serializable {
    //内容
    private String content;
    //发送方
    private String sender;
    //接收方
    private String receiver;
    //日期
    private String date;
    //消息类型
    private int type;//type=0 登陆消息，type=1 一般消息，type=2 退出消息 type=3  list消息

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Message() {
    }

    public Message(String content, String sender, String receiver) {
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
