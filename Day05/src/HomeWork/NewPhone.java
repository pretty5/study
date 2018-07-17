package HomeWork;

public class NewPhone extends Phone{


    @Override
    public void call() {
        System.out.println("我会打电话");
    }

    @Override
    public void seedMessage() {
        System.out.println("我会发短信");
    }

    public  void Internet(){
        System.out.println("我会上网");
    }
    public  void Music(){
        System.out.println("我会音乐");
    }
}
