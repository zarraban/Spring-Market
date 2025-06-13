package org.example.app.repository.product;

import org.example.app.entity.Product;
import org.example.app.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository {

    private final static Map<Long, Product> PRODUCT_MAP = new HashMap<>();

    @Override
    public void create(Product entity) {
        try {
            if (!PRODUCT_MAP.containsValue(entity)) {
                PRODUCT_MAP.put(entity.getId(), entity);
            } else {
                throw new Exception("Repository has this product alresdy");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Optional<Map<Long, Product>> getAll() {
        if (!PRODUCT_MAP.isEmpty()) {
            return Optional.of(PRODUCT_MAP);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Product getById(Long id) {
        try {
            if (PRODUCT_MAP.containsKey(id)) {
                return PRODUCT_MAP.get(id);
            } else {
                throw new NoSuchElementException("No such id in database");
            }
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean update(Long id, Product entity) {
       try {
           if(PRODUCT_MAP.containsKey(id)){
               PRODUCT_MAP.replace(id,entity);
               return true;
           }else {
               throw new NoSuchElementException("No such id in database");
           }


       }catch (NoSuchElementException e){
           System.out.println(e.getMessage());
       }
       return false;
    }

    @Override
    public boolean delete(Long id) {
        try {
            if(PRODUCT_MAP.containsKey(id)){
                PRODUCT_MAP.remove(id);
                return true;
            }else {
                throw new NoSuchElementException("No such id in database");
            }


        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

}
