package com.zhiyou100;

public class Member {

    private Member papa;
    private Member mama;
    private String name;
    private int age;

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

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
}
