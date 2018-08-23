package model;

import lombok.Data;


/*
*@ClassName:User
 @Description:TODO
 @Author:
 @Date:2018/8/21 9:44 
 @Version:v1.0
*/
//对应数据库的中user表
@Data
public class User {
    private int id;
    private String name;
    private String password;
}
