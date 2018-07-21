package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/*
*@ClassName:RegionUtil
 @Description:TODO
 @Author:
 @Date:2018/7/20 9:45 
 @Version:v1.0
*/
public class RegionUtil {


    //用来存储地区数据
   private static HashMap map=new HashMap();
    //设计第一个方法加载数据
    public static void loadData(String data){
        String[] groups = data.split(",");

        for (int i = 0; i < groups.length; i++) {
            //henan zhengzhou gongyi
            String[] strings = groups[i].split(" ");
           /* System.out.println(strings);*/
            String province=strings[0];
            String city=strings[1];
            String country=strings[2];
            if (map.containsKey(province)){
                //根据省份拿到省份区域信息  区域信息以map保存
                HashMap info = (HashMap) map.get(province);
                //如果包含了市
                if (info.containsKey(city)){
                    //把县添加到市所对应的县的list中
                    List countrys = (List) info.get(city);
                    countrys.add(country);
                    info.put(city,countrys);
                }else{
                    //如果当前没有这个市
                    //添加该市 同时添加县
                    ArrayList list = new ArrayList();
                    list.add(country);
                    info.put(city,list);
                }
            }else{
                //没省份
                //处理县级
                ArrayList list = new ArrayList();
                list.add(country);
                //处理市级别
                HashMap citys = new HashMap();
                citys.put(city,list);
                //处理省
                map.put(province,citys);
            }
        }
    }

    public static void getCitys(String province){
        HashMap citys = (HashMap) map.get(province);
        Set set = citys.keySet();
        for (Object city:
             set) {
            System.out.println(city);
        }
    }



    public static void getCountries(String province) {
        //想要拿到县 先要拿到市
        HashMap citys = (HashMap) map.get(province);
        Set set = citys.keySet();
        for (Object city:
                set) {
            String cityName= (String) city;
            List countries = (List) citys.get(cityName);
            System.out.println("city:"+cityName+"countries: "+countries);
            ///System.out.println(city);
        }
    }
}
