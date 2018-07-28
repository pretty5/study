package test;

public class Test {
    public static void main(String[] args) {
        int[] ticker = new int[10];
        new Thread(new Producer(ticker)).start();
        new Thread(new Seller(ticker)).start();
    }
}
