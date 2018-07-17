public class StringUtil {

    public static String reverse(String s) {
        char[] chars = s.toCharArray();
        char[] reverse = new char[s.length()];
        for (int i = s.length()-1; i >= 0 ; i--) {
            reverse[s.length()-1-i]=chars[i];
        }
        // String s = new String(reverse)
        return new String(reverse);
    }
    //使用stringbuffer直接反转

    //string 表示的是字符串 是不可变的。 string a="hello1";"hello","hello1"
    //当对字符串进行拼接的时候，会生成一个新的字符串对象。当频繁的进行字符串拼接的时候
    //随着时间的推移，可能会造成内存溢出。

    // stringbuilder 表示也是字符串，只不过对字符串做了一层封装。在拼接字符串的时候。
    //由于封装，不会频繁的创建新的对象。也就是不会出现内存溢出。

    // stringbuffer 跟stringbuidler功能完全一样。只不过stringbuffer可以在多线程
    //环境下使用，stringbuilder一般在单线程环境下使用。

    //stringbuilder在单线程环境下 性能更优。
    public static String reverse2(String s) {

        //将字符串编程stringbuffer，需要调用stringBuffer的构造方法
        StringBuffer stringBuffer = new StringBuffer(s);

        StringBuffer reverse = stringBuffer.reverse();
        //要将stringBuffer转换成字符串需要调用toString（）
        //return  reverse.toString();

        //return new StringBuffer(s).reverse().toString();
        return new StringBuilder(s).reverse().toString();
    }


    public static boolean isEmpty(String a) {
        //判断字符串为"",不能用==，只能用equal。
        //在java中对象的比较不能使用==，基本数据类型的比较可以用==
        //java规定，对象的比较，需要调用对象的equals（）
        //所有对象都有equals方法
        //a.equals(null)只比较内容，不比较地址（前提是有对象）
        // a ==null 和d==null相等（都在堆中，地址一样（java默认处理的））
        // 如果new  String 等于开辟新的一个堆空间，地址不一样，不相等
        //
        if (a==null||a.equals("")){
            return true;
        }
        return false;
    }
}
