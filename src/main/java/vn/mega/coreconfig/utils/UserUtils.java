package vn.mega.coreconfig.utils;


public class UserUtils {


    // implement by spring security
    public static String getCurrentUser() {
        return "admin";
    }

    public static String getSelectedTenant() {
        return "ADMIN";
    }

}
