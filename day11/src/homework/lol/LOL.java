package homework.lol;

/*
*@ClassName:LOL
 @Description:TODO
 @Author:
 @Date:2018/7/11 10:15 
 @Version:v1.0
*/
public class LOL {
    public static void main(String[] args) {
        //
        Hero yase = new Hero("yase", 3000);

        Hero libai = new Hero("libai", 1500);



        libai.attack(yase);

        yase.attack(libai);


    }
}
