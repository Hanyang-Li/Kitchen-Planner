package com.xin.springboot.respository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserinfoRespositoryTest {

    @Autowired
    private UserinfoRespository userinfoRespository;

    @Test
    void findAll(){
        System.out.println(userinfoRespository.findAll());
    }

    @Test
    void findByUsername (){
        System.out.println(userinfoRespository.findByUsername("wangwu"));
    }

    @Test
    void findByPhone(){
        System.out.println(userinfoRespository.findByPhone("15927691023"));
    }

    @Test
    void findByEmail(){
        System.out.println(userinfoRespository.findByEmail("asdfghjkl135462@163.com"));
    }
}