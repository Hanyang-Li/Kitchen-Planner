package com.xin.springboot.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Encryption {

    public static String MD5Encryption(String username, String password){
        String src = username + password;
        try{
            MessageDigest md5 = MessageDigest.getInstance("md5");

            byte[] b = src.getBytes();

            byte[] digest = md5.digest(b);

            char[] chars = new char[]{
                    '0','1','2','3','4','5','6','7','A','B','C','d','o','*','#','/'};

            StringBuffer sb = new StringBuffer();
            for (byte bb : digest){

                sb.append(chars[(bb >> 4) & 15]);
                sb.append(chars[bb & 15]);
            }


            return sb.toString();

        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("nihao",1);
        map.put("woshi",2);
        System.out.println(map.get("nihao"));

    }
}
