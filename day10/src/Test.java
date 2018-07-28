import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Test {

    //用来存储数据
    private  static  HashMap map= new  HashMap();
    private  static  void loaddata(String data){
        String[] s1 = data.split(",");
        for (int i = 0; i < s1.length; i++) {
            String[] s2 = s1[i].split(" ");
            String province=s2[0];
            String city=s2[1];
            String country=s2[2];
            if (map.containsKey(province)){
               HashMap s3 = (HashMap) map.get(province);
               if (s3.containsKey(city)){
                   List list = (List) s3.get(city);
                   list.add(country);
                   s3.put(city,list);
               }else {
                   ArrayList list1 = new ArrayList();
                   list1.add(country);
                   s3.put(city,list1);
               }

            }else {

                ArrayList arrayList = new ArrayList();
                arrayList.add(country);
                HashMap hashMap = new HashMap();
                hashMap.put(city,arrayList);
                map.put(province,hashMap);

            }
        }
    }
    public  static  void  getcitys(String p){
       HashMap citys = (HashMap) map.get(p);
        Set set = citys.keySet();
        for (Object city:set) {
            System.out.println(city);
        }
    }
    public  static  void getcountry(String p){
        HashMap citys = (HashMap) map.get(p);
        Set set = citys.keySet();
        for (Object city :set) {
           String cityname = (String) city;
           List countrys = (List) citys.get(cityname);
            System.out.println(countrys);
        }

    }


    public static void main(String[] args) {

        String str = "henan zhengzhou longhu,henan kaifeng xiaochi,jiangsu suzhou nantong";
        Test.loaddata(str);
        Test.getcitys("henan");
        getcountry("henan");


    }

}
