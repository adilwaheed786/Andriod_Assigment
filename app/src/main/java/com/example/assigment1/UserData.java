package com.example.assigment1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserData {

    public static List<User> users = new ArrayList<User>();
    public static void initializeUsers(){
        addUsers("adil","waheed", "20", "ad@gmail.com","abc");

    }

    public static void addUsers(String first, String lastname, String age, String Email, String pass){
        User data = new User(first,lastname,age,Email,pass);
        users.add(data);
    }

    public static User login(String username, String password){
        for (User data: users) {
            if(data.first.equals(username) && data.pass.equals(password)){
                return data;
            }
        }
        return null;
    }
}

class User implements Serializable {

    //    String username;
    String first;
    String last;
    String pass;
    String email;
    String age;

    User(String first, String last, String age, String email, String password){
//        this.username = first+last;
        this.first=first;
        this.last=last;
        this.age = age;
        this.email = email;
        this.pass = password;
    }
    User(){
//        this.username = "";
        this.first = "";
        this.last = "";
        this.pass = "";
        this.email = "";
        this.age = "";
    }
}
