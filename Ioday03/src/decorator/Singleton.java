package decorator;

/*
*@ClassName:Singleton
 @Description:TODO
 @Author:
 @Date:2018/7/26 10:15 
 @Version:v1.0
*/
public class Singleton {

    //懒汉式:在使用对象的时候才去创建对象 私有静态引用 why:通过这个引用指向单例
    //private static Singleton instance;
    //饿汉式：定义属性的时候直接创建对象
    private static Singleton instance=new Singleton();
    //私有无参构造 why:不让客户端通过new的方式创建对象
    private Singleton(){
    }
    //公开静态方法 用来返回实例
    public static Singleton getInstance(){
        //懒汉式:在使用对象的时候才去创建对象

        if (instance == null) {
            instance=new Singleton();
        }

        return instance;
    }

}
