package com.jewlleryShop;

public class Login {

    private static final String ADMIN_USERNAME = "sanjay";

    private static final String ADMIN_PASSWORD = "sanjay@2005";

    private static final String OTHER_USERNAME = "SANJAY18";

    private static final String OTHER_PASSWORD = "Sanjay@05";



    public static boolean authenticate(String username, String password) {

        return OTHER_USERNAME.equals(username) && OTHER_PASSWORD.equals(password);

    }



    public static boolean isAdmin(String username, String password) {

        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);

    }

}