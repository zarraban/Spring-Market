package org.example.app.repository.product;

import lombok.extern.slf4j.Slf4j;
import org.example.app.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;


@Slf4j
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
        catch (Exception e){;
           logError(e);
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
            logError(e);
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
           logError(e);
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
            logError(e);
        }
        return false;
    }
    private void logError(Exception e){
        log.error("Error occurred: {}",e.getMessage());
    }
}
