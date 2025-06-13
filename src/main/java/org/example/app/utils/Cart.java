package org.example.app.utils;

import lombok.extern.slf4j.Slf4j;
import org.example.app.entity.Product;
import org.springframework.stereotype.Component;


import java.util.HashMap;

import java.util.Map;
import java.util.NoSuchElementException;

import java.util.concurrent.atomic.AtomicLong;


@Slf4j
@Component
public class Cart {
    private final Map<Long,Product> map = new HashMap<>();
    private static AtomicLong id = new AtomicLong(0);


    public void delete(Long id){
        try {
            if(map.containsKey(id)){
                map.remove(id);
            }else {
                throw new NoSuchElementException("Cart doesn't have this product");
            }

        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            log.error("Error occurred: {}",e.getMessage());
        }
    }

    public void add(Product product){
    map.put(id.getAndIncrement(),product);
    }

    public boolean isEmpty(){
        return map.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Cart has: \n");
        map.forEach((k,v)-> sb.append(k).append(")").append(" ").append(v).append("\n"));
        return sb.toString();
    }
}
