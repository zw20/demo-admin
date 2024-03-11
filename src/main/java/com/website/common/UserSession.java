package com.website.common;

public class UserSession {
    private static String userAgent;
    private static final ThreadLocal<User> userTreadLocal = new ThreadLocal<>();


    public static void addUser(User user){
        userTreadLocal.set(user);
    }

    public static  User getCurrentUser(){
        return userTreadLocal.get();
    }

    public static void removeCurrentUser(){
        userTreadLocal.remove();
    }

    public static String getUserAgent() {
        return userAgent;
    }

    public static void setUserAgent(String userAgent) {
        UserSession.userAgent = userAgent;
    }
}
