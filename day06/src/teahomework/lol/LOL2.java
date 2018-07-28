package teahomework.lol;

import com.homework.lol.Equipment;
import com.homework.lol.Hero;

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
        com.homework.lol.Equipment dagoubang = new com.homework.lol.Equipment(0, 10, "dagoubang", 100);

        com.homework.lol.Equipment yitianjian = new com.homework.lol.Equipment(0, 20, "yitianjian", 1000);
        //防御装备
        com.homework.lol.Equipment riyandoupeng = new com.homework.lol.Equipment(1, 5, "日炎斗篷", 200);

        com.homework.lol.Equipment ruanweijia = new Equipment(1, 8, "ruanweijia", 500);

        //创造几个盖世英雄

        com.homework.lol.Hero bajie = new com.homework.lol.Hero("bajie", 10,5,10);

        com.homework.lol.Hero gailun = new Hero("gailun", 20,4,9);

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
        for (int i = 0; i < 100; i++) {
            bajie.attack(gailun);
            Thread.sleep(100);
        }
    }
}
