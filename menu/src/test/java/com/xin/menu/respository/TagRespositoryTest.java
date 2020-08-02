package com.xin.menu.respository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TagRespositoryTest {

    @Autowired
    private TagRespository tagRespository;

    @Test
    void findById(){
        System.out.println(tagRespository.findById(1).get());
    }
}