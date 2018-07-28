package thread;



public class ThreadDemo   {
    public static void main(String[] args) {
        //testextends();
        //testthread();
        new Thread(new Hellorunnable()).start();
    }


    private static void testthread()  {
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("hello");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //new Thread(run1).run();
        //run1.run();
       // new Thread(run1).start();
        System.out.println("world");

        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("zhengzhou");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(run2).start();
    }

    private static void testextends() {
        new Mythread().start();
        //new Mythread().run();
        System.out.println("henan");
    }
}
