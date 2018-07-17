package oop;

public class Calcultor {
    public int add(int x,int y){
        return  x+y;
    }

    public int minus(int x,int y){
        return  x-y;
    }

    public static void main(String[] args) {
        Calcultor calcultor = new Calcultor();
        calcultor.add(1,1);
        calcultor.minus(1,1);
        System.out.println(calcultor.add(1,1));

    }

}
