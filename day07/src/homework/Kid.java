package homework;

public class Kid {
    /*public static Play f1() {
        return null;
    }*/
     static Play f1(){
         return new Play() {
            @Override
            public void swim() {
                System.out.println("i can swim");
            }
        };
    }


}
