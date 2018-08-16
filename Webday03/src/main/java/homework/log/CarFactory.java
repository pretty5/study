package homework.log;

/*
*@ClassName:CarFactory
 @Description:TODO
 @Author:
 @Date:2018/8/15 9:30 
 @Version:v1.0
*/
/*
工厂模式是一种设计模式 ，可以快捷，方便的创建对象，它最大的好处在于解耦：降低关联性，增强代码可维护性。
也就是说将对象的创建的权力交给工厂，客户端不需要去创建。
当创建一些复杂对象的时候，工厂模式比较简单。
 */
public class CarFactory {
    public static Car getCar(String name){
        if (name.equals("benz")){
            return new Benz();
        }else if (name.equals("bmw")){
            return new BMW();
        }
        return null;
    }
}
