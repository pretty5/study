package lianxi;

import java.util.ArrayList;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        q1();

    }

    private static void q1() {
        ArrayList list = new ArrayList();
        Score score1 = new Score(99, 100);
        Score score2 = new Score(99, 100);
        Score score3 = new Score(99, 100);
        list.add(score1);
        list.add(score2);
        list.add(score3);
        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Score s1 = (Score) o1;
                Score s2 = (Score) o2;
                if (s1.getSum()>s2.getSum()){
                    return -1;
                }else if (s1.getSum()==s2.getSum()){
                    if (s1.getChinese()>s2.getChinese()){
                        return -1;
                    }
                }
                return 1;
            }
        });
        System.out.println(list);

    }


}
