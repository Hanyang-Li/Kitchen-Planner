package com.xin.menu.respository;


import com.xin.menu.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRespository extends JpaRepository<Tag,Integer> {

    Tag findByName(String name);
}
