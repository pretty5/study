package extend;

/*
*@ClassName:Father
 @Description:TODO
 @Author:
 @Date:2018/7/12 11:18 
 @Version:v1.0
*/

//定义一个父类
/*
       子类拥有父类的public,protected方法
       子类不能拥有父类的私有方法

       子类拥有父类的属性。

       子类调用父类的方法，如果子类重写，则会调用重写后的方法，
       如果没有重写，则默认调用父类的方法。

       如果父类的方法是final 子类不能重写

       why:
       节省代码量。



 */
public class Father {
    //定义两个属性
    private String name;
    private int age;

    private void work() {
        System.out.println("i can work");
    }

    public final void zuoren(){
        System.out.println("不能伤天害理");
    }

    protected void drive(){
        System.out.println("i can drive");
    }

    public Father(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
