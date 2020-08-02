package com.xin.menu.respository;

import com.xin.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRespository extends JpaRepository<Menu,Integer> {

    List<Menu> findByMenuname(String name);

    List<Menu> findByAuthorid(Integer authorid);

    @Query("select new Menu(h.id,h.menuname,h.authorid,h.imgpath,h.authorname) from Menu h ")
    List<Menu> findByIsad(Integer isad);
}

