package test;

public class Filesave {
    public static void main(String[] args) {
        String s = "hello henan world";
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            String path = "d:\\text\\iotest"+i;
            String con = split[i];
           new Thread(new ThreadUtil(path,con)).start();
        }
    }
}
