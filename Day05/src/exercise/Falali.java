package exercise;

public class Falali extends  Car {
    @Override
    public void runto(String dst) {
        super.runto(dst);
        System.out.println("开心的去");
    }

    public static void main(String[] args) {
        Falali falali = new Falali();
        falali.runto("北美");

    }

}
