package com.xin.springboot.controller;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xin.springboot.entity.Userinfo;
import com.xin.springboot.respository.UserinfoRespository;
import com.xin.springboot.utils.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/userinfo")
public class UserinfoHandler {

    @Autowired
    private UserinfoRespository userinfoRespository;



    @GetMapping("/ExistUsername/{username}")
    public boolean ExistUsername(@PathVariable("username") String username){
        return userinfoRespository.findByUsername(username) != null;
    }

    @GetMapping("/ExistPhone/{phone}")
    public boolean ExistPhone(@PathVariable("phone") String phone){
        return userinfoRespository.findByPhone(phone) != null;
    }

    @GetMapping("/ExistEmail/{email}")
    public boolean ExistEmail(@PathVariable("email") String email){
        return userinfoRespository.findByEmail(email) != null;
    }


    @PostMapping("/signup")
    public String signup(@RequestBody Userinfo userinfo) throws JsonProcessingException {
        String pass = Encryption.MD5Encryption(userinfo.getUsername(),userinfo.getPass());
        HashMap<String, String> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        if (pass == null){
            map.put("message","error");

        }
        userinfo.setPass(pass);
        Userinfo result = userinfoRespository.save((userinfo));
        if(result != null){
            map.put("message","success");

        }
        else{
            map.put("message","error");

        }
        return objectMapper.writeValueAsString(map);
    }

    @PostMapping("/signin")
    public String signin(@RequestHeader Map<String, Object> header, @RequestBody Userinfo userinfo) throws JsonProcessingException {
        //System.out.println(header);
        Userinfo result = userinfoRespository.findByUsername(userinfo.getUsername());
        userinfo.setPass(Encryption.MD5Encryption(userinfo.getUsername(),userinfo.getPass()));
        HashMap<String, String> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        if(result != null){
            if(result.getPass().equals(userinfo.getPass())){
                map.put("message","token" + "_" + userinfo.getUsername() + "_" + userinfo.getPass());

            }
            else{
                map.put("message","error");

            }
        }
        else{
            map.put("message","error");

        }
        return objectMapper.writeValueAsString(map);
    }

    @GetMapping("/check")
    public String check(@RequestHeader Map<String, Object> header) throws JsonProcessingException {
        Map<String,String> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        if(header.get("authorization") != null){
            String token = (String) header.get("authorization");
            String username = token.split("_")[1];
            map.put("message",username);
        }
        else{
            map.put("message","error");

        }
        return objectMapper.writeValueAsString(map);
    }
}
