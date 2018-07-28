package collection;

import java.util.ArrayList;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(5);
        list.add(2);
        list.add(9);
        list.add(4);
        list.add(3);
        list.add(3);
       /*list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer num1 = (Integer) o1;
                Integer num2 = (Integer) o2;
               *//* if (num1<num2){
                    return -1;
                }else if (num1>num2){
                    return 1;
                }else {
                    return 0;
                }*//*

               // return num1<num2?-1:1;

                return num1.compareTo(num2);
            }

        });
        System.out.println(list);

*/

        quicksort(list);
        System.out.println(quicksort(list));
    }

    private static ArrayList quicksort(ArrayList list) {
        if (list.size() <=1){
            return list;
        }
        Integer head = (Integer) list.get(0);
        ArrayList left = new ArrayList();
        ArrayList mid = new ArrayList();
        ArrayList right = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Integer element = (Integer) list.get(i);
            if (element < head) {
            left.add(element);
            }else if (element>head){
                right.add(element);
            }else {
                mid.add(element);
            }
        }
        ArrayList result = new ArrayList();
        result.addAll(quicksort(left));
        result.addAll(mid);
        result.addAll(quicksort(right));
        return result;

    }
}
