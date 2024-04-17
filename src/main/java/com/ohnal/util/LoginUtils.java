package com.ohnal.util;

import jakarta.servlet.http.HttpSession;

public class LoginUtils {
    public static final String LOGIN_KEY = "login";
    public static boolean isLogin(HttpSession session) {
        return session.getAttribute(LOGIN_KEY) != null;
    }
    public static String getLoginUserEmail(HttpSession session) {
        return null;
    }
}
