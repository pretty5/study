package teahomework.lol;

/*
*@ClassName:LOL2
 @Description:TODO
 @Author:
 @Date:2018/7/12 9:56 
 @Version:v1.0
*/
public class LOL2 {
    public static void main(String[] args) throws InterruptedException {
        //创造几件绝世神器
        Equipment dagoubang = new Equipment(0, 10, "dagoubang", 100);

        Equipment yitianjian = new Equipment(0, 20, "yitianjian", 1000);
        //防御装备
        Equipment riyandoupeng = new Equipment(1, 5, "日炎斗篷", 200);

        Equipment ruanweijia = new Equipment(1, 8, "ruanweijia", 500);

        //创造几个盖世英雄

        Hero bajie = new Hero("bajie", 10,5,10);
        Hero wukong = new Hero("wukong", 10,18,10);

        Hero gailun = new Hero("gailun", 20,4,9);

        //打斗正式开始
        bajie.attack(gailun);
        wukong.attack(gailun);
        gailun.attack(bajie);

        bajie.wear(yitianjian);

        bajie.attack(gailun);

        gailun.wear(riyandoupeng);

        bajie.attack(gailun);

        gailun.wear(ruanweijia);

        bajie.attack(gailun);

        gailun.wear(ruanweijia);

        bajie.attack(gailun);
        for (int i = 0; i < 100; i++) {
            bajie.attack(gailun);
            Thread.sleep(100);
        }
    }
}
