package Inner;

public class AnonymousClasss {
    public static void main(String[] args) {
      /*  new Inner() {
            @Override
            public void name() {
                System.out.println("haha");
            }
        }.name();*/

        Inner inner = new Inner() {
            @Override
            public void name() {
                System.out.println("wo de ming zi");
            }
        };
        inner.name();
    }
}
