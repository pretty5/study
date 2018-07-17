package HomeWork;

public class LOL {

    public static void main(String[] args) {
        //创造几件绝世神器
        Equipment dagoubang = new Equipment(0, 10, "dagoubang", 100);

        Equipment yitianjian = new Equipment(0, 20, "yitianjian", 1000);
        //防御装备
        Equipment riyandoupeng = new Equipment(1, 5, "日炎斗篷", 200);

        Equipment ruanweijia = new Equipment(1, 8, "ruanweijia", 500);

        //创造几个盖世英雄

        Hero bajie = new Hero("bajie", 10,5,10);

        Hero gailun = new Hero("gailun", 20,4,9);

        //打斗正式开始
        bajie.attack(gailun);

        gailun.attack(bajie);

        bajie.wear(yitianjian);

        bajie.attack(gailun);

        gailun.wear(riyandoupeng);

        bajie.attack(gailun);

        gailun.wear(ruanweijia);

        bajie.attack(gailun);

        gailun.wear(ruanweijia);

        bajie.attack(gailun);


    }
}
