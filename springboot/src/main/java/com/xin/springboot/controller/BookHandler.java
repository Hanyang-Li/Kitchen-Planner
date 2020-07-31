package com.xin.springboot.controller;


import com.xin.springboot.entity.Book;
import com.xin.springboot.respository.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookHandler {

    @Autowired
    private BookRespository bookRespository;

    @GetMapping("/findAll/{path}/{size}")
    public Page<Book> findAll(@PathVariable("path") Integer page, @PathVariable("size") Integer size){
        Pageable pageable = PageRequest.of(page-1,size);
        return bookRespository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Book book){
        Book result = bookRespository.save((book));
        if(result != null){
            return "success";
        }
        else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return bookRespository.findById(id).get();

    }

    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book result = bookRespository.save((book));
        if(result != null){
            return "success";
        }
        else{
            return "error";
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        bookRespository.deleteById(id);

    }
}
