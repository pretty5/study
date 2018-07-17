public class HomeWork {
    public static void main(String[] args) {
        // q1();
        q2();
    }

    private static void q2() {
        String a = null;
        String b = "";
        String c = "hello";
        //定义一个可以判断空字符串的方法
        //约定：当返回值为boolean类型的时候，一般将方法的名字前加is
        //之所以字符串比较特殊是因为
        //1.字符串是编程中遇到最多的对象。jvm为了提高代码的性能，内部做了优化
        //2.在多线程环境下，为了保证线程安全，字符串对象本身不可变
        boolean flag = StringUtil.isEmpty(a);
        boolean flag1 = StringUtil.isEmpty(b);
        boolean flag2 = StringUtil.isEmpty(c);

        System.out.println(flag);
        System.out.println(flag1);
        System.out.println(flag2);

        String d="";

        String e=new String("");

        System.out.println(d==e);

        System.out.println(d==b);

    }

    //测试字符串工具类
    private static void q1() {
        String s = "hello";
        //测试字符串反转
        String res = StringUtil.reverse(s);
        System.out.println(res);

        String res2 = StringUtil.reverse2(s);

        System.out.println(res2);

    }
}
