package teahomework.lol;

/*
*@ClassName:Equipment
 @Description:TODO
 @Author:
 @Date:2018/7/12 9:03 
 @Version:v1.0
*/
//装备
public class Equipment {
    //装备的类型，0 代表攻击类型  1 代表防御类型
    private  int type;
    //装备所带来的属性加成
    private int buffer;
    //装备的名字
    private String name;
    //装备的价格
    private int price;
    //生成一个带全部属性的构造方法
    public Equipment(int type, int buffer, String name, int price) {
        this.type = type;
        this.buffer = buffer;
        this.name = name;
        this.price = price;
    }
    //生成setter  和getter方法

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getBuffer() {
        return buffer;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "type=" + type +
                ", buffer=" + buffer +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
