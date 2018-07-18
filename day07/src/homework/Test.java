package homework;

public class Test {
    public static void  main(String args[]){
        Test t  = new Test ();
        int  b =  t.get();
        System.out.println(b);

    }

    public int  get()
    {

        try {
            return 1;
        }finally{
            return 2;
        }

    }
}
