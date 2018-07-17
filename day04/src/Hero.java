public class Hero {
    private String name;
    private  int blood;

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

    public Hero(String name, int blood) {
        this.name = name;
        this.blood = blood;
    }

    public  void attack(Hero hero){
        hero.setBlood(hero.getBlood()-50);
        System.out.println(this.name+"攻击了"+hero.getName()+"50点暴击");

    }
}
