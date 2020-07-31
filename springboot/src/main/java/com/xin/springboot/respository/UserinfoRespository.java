package com.xin.springboot.respository;

import com.xin.springboot.entity.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserinfoRespository extends JpaRepository<Userinfo,Integer> {
    Userinfo findByUsername(String username);
    Userinfo findByPhone(String phone);
    Userinfo findByEmail(String email);
}
