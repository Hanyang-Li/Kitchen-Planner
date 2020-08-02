package com.xin.menu.respository;

import com.xin.menu.entity.Menutotag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenutotagRespository extends JpaRepository<Menutotag,Integer> {

    List<Menutotag> findByMenuid(Integer menuid);


    Page<Menutotag> findByTagid(Integer tagid, Pageable pageable);
}
