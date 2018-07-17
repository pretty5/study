package extend;

/*
*@ClassName:Child
 @Description:TODO
 @Author:
 @Date:2018/7/12 11:20 
 @Version:v1.0
*/
//继承于父类
public class Child extends Father  {
    //添加一个自己的属性

    private String toy;

    public Child(String name, int age) {
        //super是一个关键字   表示父类的构造方法
        super(name, age);
    }

    public String getToy() {
        return toy;
    }

    public void setToy(String toy) {
        this.toy = toy;
    }
    //注解：标识当前这个方法是来自父类的方法，并且需要 重写
    @Override
    protected void drive() {
        //super.drive();
        System.out.println("i can drive and i can shift");

    }

}
