package homework.lol;

import com.homework.lol.Equipment;

import java.util.Arrays;

/*
*@ClassName:Hero
 @Description:TODO
 @Author:
 @Date:2018/7/11 10:07 
 @Version:v1.0
*/
public class Hero {
    //表示纵向坐标
    private int y;
    //表示横向坐标
    private int x;
    //定义金钱属性
    private int money;

    //击杀数
    private int kill;
    //死亡数
    private int death;

    public int getKill() {
        return kill;
    }

    public void setKill(int kill) {
        this.kill = kill;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    //名字
    private String name;

    //血量
    private int blood;
    //初始血量
    private int initBlood;

    public int getInitBlood() {
        return initBlood;
    }

    public void setInitBlood(int initBlood) {
        this.initBlood = initBlood;
    }

    //攻击力
    private int atk;
    //防御力
    private int def;
    //定义一个两个长度的数组 用来存放装备
    private com.homework.lol.Equipment[] equs = new com.homework.lol.Equipment[2]; //null
    //目前拥有几件装备
    private int equNum = 0;

    public Hero(String name, int blood, int atk, int def) {
        this.name = name;
        this.blood = blood;
        this.atk = atk;
        this.def = def;
        this.initBlood=blood;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    //定义一个方法 用来添加装备
    public void wear(Equipment equ) {
        //判断装备的容量是否满了  如果满了 就不能添加
        if (equNum == 2) {
            //对于返回值为void的方法，如果中间想停止执行，可以使用return；
            return;
        }
        //装备池没有满，可以穿装备，先把装备放到装备池里边。
        equs[equNum] = equ;
        equNum++;
        //如果装备是攻击力的装备
        if (equ.getType() == 0) {
            //要给英雄的攻击属性加成
            atk += equ.getBuffer();
        } else {
            def += equ.getBuffer();
        }


    }


    public Hero(String name, int blood) {
        this.name = name;
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    //攻击  造成对方血量降低
    public void attack(Hero hero) {
        //计算本次攻击带来的伤害
        int damage = this.getAtk() - hero.getDef();
        //如果伤害值为负数，不掉血
        if (damage < 0) {
            System.out.println(this.toString());
            System.out.println(hero.toString());
            //System.out.println("打不动，敌方护甲值：" + hero.getDef() + "我方的攻击力为： " + this.getAtk());
            return;
            //否则敌方英雄血量减去伤害值
        } else {
            //判断此次攻击以后的血量是否小于等于0
            int lastestBlood=hero.getBlood()-damage;
            if (lastestBlood<=0){
                //设置的是对方的初始血量，
                this.setKill(this.getKill()+1);
                this.money+=350;
                //hero.death++;
                hero.setDeath(hero.getDeath()+1);

                hero.setBlood(hero.getInitBlood());
               // hero.setBlood(initBlood);
                System.out.println(this.toString());
                System.out.println(hero.toString());
                //System.out.println(hero.getName()+"已战亡，重生，血量恢复至最初血量："+hero.getBlood());
            }else{
                hero.setBlood(lastestBlood);
                System.out.println(this.toString());
                System.out.println(hero.toString());
               /* System.out.println("造成伤害：" + damage + "我方的攻击力为： " + this.getAtk() + "敌方护甲值：" + hero.getDef()
                +"敌方血量： "+hero.getBlood());*/

            }
           }


        //hero.setBlood(hero.getBlood()-50);
        //System.out.println(this.name+"攻击了"+hero.getName()+",造成50点暴击");
    }

    @Override
    public String toString() {
        return "Hero{" +
                "kill=" + kill +
                ", death=" + death +
                ", name='" + name + '\'' +
                ", blood=" + blood +
                ", initBlood=" + initBlood +
                ", atk=" + atk +
                ", def=" + def +
                ", equs=" + Arrays.toString(equs) +
                ", equNum=" + equNum +
                '}';
    }

    //定义移动方法
    public void move(int direction){
        //0 上
        //1 下
        //2 左
        //3 右
        if (direction==0||direction==3){
            x+=10;
            y+=10;
        }else{
            x-=10;
            y-=10;
        }

    }
    //定义闪现
    public void jump(int direction){
        //0 上
        //1 下
        //2 左
        //3 右
        if (direction==0||direction==3){
            x+=100;
            y+=100;
        }else{
            x-=100;
            y-=100;
        }

    }
}
