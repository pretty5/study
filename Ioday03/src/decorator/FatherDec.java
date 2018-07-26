package decorator;

/*
*@ClassName:FatherDec
 @Description:TODO
 @Author:

 @Date:2018/7/26 9:48 
 @Version:v1.0
*/
//装饰模式 包装模式
//继承自父类
//定义父类的一个属性
//为什么继承：只有继承才能拥有父类的方法，才拥有重写的权利
/*
    相比继承来说，装饰模式大大减少了子类的数量，重写的规模
 */



public class FatherDec extends  Father {
    //定义了一个被装饰的对象
    private Father father;
    //生成构造方法
    public FatherDec(Father father) {
        this.father = father;
    }
    //重写父类的方法
    @Override
    public void eat() {
        //在被装饰方法前可以做一些事情
        System.out.println("听音乐");
        //被装饰的方法
        father.eat();
        //在被装饰方法后可以做一些事情
        System.out.println("来一根");
    }
}
