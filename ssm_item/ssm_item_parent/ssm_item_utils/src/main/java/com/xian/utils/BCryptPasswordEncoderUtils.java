package com.xian.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password="666";
        String pwd = encodePassword(password);
        //$2a$10$em8py4hvB3Gmy25NVAm5W.lx4tFIrkglZWMwc57aOclOmpZoy5f26

        System.out.println(pwd);
        System.out.print(pwd.length());
    }
}
