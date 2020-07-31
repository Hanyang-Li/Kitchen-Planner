package com.xin.springboot.respository;

import com.xin.springboot.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRespositoryTest {

    @Autowired
    private BookRespository bookRespository;

    @Test
    void findAll(){

        System.out.println(bookRespository.findAll());
    }

    @Test
    void save(){
        Book book = new Book();

        book.setName("Spring Boot");
        book.setAuthor("zhangsan");
        Book book1 = bookRespository.save(book);
        System.out.println(book1);
    }

    @Test
    void findById(){
        Book book = bookRespository.findById(1).get();
        System.out.println(book);
    }

    @Test
    void delete(){
        bookRespository.deleteById(126);
    }

}