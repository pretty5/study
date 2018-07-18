package homework;

public class ReturnException {
    public static void main(String[] args)
    {
        try
        {
            System.out.println("try");
            return;
        }
        catch (Exception e)
        {
            System.out.println("catch");
            e.printStackTrace();
        }
        finally
        {
            System.out.println("finally");
        }
        System.out.println("ok");
    }
}
