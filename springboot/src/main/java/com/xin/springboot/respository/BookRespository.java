package com.xin.springboot.respository;

import com.xin.springboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRespository extends JpaRepository<Book,Integer> {
}
