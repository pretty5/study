package com.zhiyou100;

public class Family {
    private Member papa;
    private Member mama;
    private Member child;

    public Member getPapa() {
        return papa;
    }

    public void setPapa(Member papa) {
        this.papa = papa;
    }

    public Member getMama() {
        return mama;
    }

    public void setMama(Member mama) {
        this.mama = mama;
    }

    public Member getChild() {
        return child;
    }

    public void setChild(Member child) {
        this.child = child;
    }

    public static void main(String[] args) {
        Family family = new Family();

        Member datou = new Member();
        datou.setName("datouerzi");
        datou.setAge(2);

        Member  xiaotou= new Member();
        xiaotou.setName("xiaotou");
        xiaotou.setAge(30);

        Member  weiqun= new Member();
        weiqun.setName("weiqun");
        weiqun.setAge(30);

        datou.setMama(weiqun);
        datou.setPapa(xiaotou);

        family.setChild(datou);
        family.setMama(weiqun);
        family.setPapa(xiaotou);

        family.getPapa().getAge();

        Member yeye = new Member();
        yeye.setName("laotou");
        yeye.setAge(68);

        family.getPapa().setPapa(yeye);

        family.getChild().getPapa().getPapa();

    }
}
