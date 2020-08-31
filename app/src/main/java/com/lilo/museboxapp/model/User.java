package com.lilo.museboxapp.model;

//singleton user class
public class User {

    // static variable single_instance of type Singleton
    private static User theUser = null;

    // variable of type String
    public String userUsername;
    public String userEmail;
    public String profileImageUrl;
    public String userId;
    public String userInfo;

    // private constructor restricted to this class itself
    private User()
    {
        userEmail = null;
        userUsername = null;
        profileImageUrl = null;
        userId = null;
        userInfo = null;
    }

    // static method to create instance of Singleton class
    public static User getInstance()
    {
        if (theUser == null)
            theUser = new User();

        return theUser;
    }

}
