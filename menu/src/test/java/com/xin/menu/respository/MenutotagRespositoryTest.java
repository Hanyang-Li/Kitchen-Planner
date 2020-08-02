package com.xin.menu.respository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenutotagRespositoryTest {

    @Autowired
    private MenutotagRespository menutotagRespository;

    @Test
    void findByMenuid(){
        System.out.println(menutotagRespository.findByMenuid(1));
    }

    @Test
    void findByTagid(){
        Pageable pageable = PageRequest.of(0,3);
        System.out.println(menutotagRespository.findByTagid(1,pageable).getTotalElements());
    }

}