package com.xin.menu.controller;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xin.menu.entity.Menu;
import com.xin.menu.entity.Menutotag;
import com.xin.menu.entity.Tag;
import com.xin.menu.respository.MenuRespository;
import com.xin.menu.respository.MenutotagRespository;
import com.xin.menu.respository.TagRespository;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuRespository menuRespository;
    @Autowired
    private MenutotagRespository menutotagRespository;
    @Autowired
    private TagRespository tagRespository;


    @GetMapping("/index")
    public List<Menu> index(){

        List<Menu> result = menuRespository.findByIsad(1).subList(0,18);

        for(int i=0;i<result.size();i++){
            List<Menutotag> temp = menutotagRespository.findByMenuid(result.get(i).getId());
            for(int j=0;j<temp.size();j++){
                result.get(i).addTaginfo(tagRespository.findById(temp.get(j).getTagid()).get());
            }
        }
        return result;

    }

    @GetMapping("/bycategory/{id}/{page}/{size}")
    public String bycategory(@PathVariable("id") Integer tagid,@PathVariable("page") Integer page,
                             @PathVariable("size") Integer size) throws JsonProcessingException {

        Pageable pageable = PageRequest.of(page,size);
        Map<String,Object> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        Page<Menutotag> temp1 = menutotagRespository.findByTagid(tagid,pageable);
        Integer totalPages = temp1.getSize();
        Long totalElements = temp1.getTotalElements();
        List<Menutotag> temp = temp1.getContent();
        List<Menu> result = new ArrayList<>();
        for (int i=0;i<temp.size();i++){
            Menu menu = menuRespository.findById(temp.get(i).getMenuid()).get();

            List<Menutotag> temp2 = menutotagRespository.findByMenuid(temp.get(i).getMenuid());

            for(int j=0;j<temp2.size();j++){

                menu.addTaginfo(tagRespository.findById(temp2.get(j).getTagid()).get());
            }
            result.add(menu);


        }
        map.put("content",result);
        map.put("totalpage",totalPages);
        map.put("totalelement",totalElements);
//        System.out.println(result);
        return objectMapper.writeValueAsString(map);
    }

}
