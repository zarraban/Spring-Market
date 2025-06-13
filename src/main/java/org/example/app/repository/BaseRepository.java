package org.example.app.repository;

import java.util.Map;
import java.util.Optional;



public interface BaseRepository <T>{
    void create(T entity);

    Optional<Map<Long,T>> getAll();

    T getById(Long id);

    boolean update(Long id, T entity);

    boolean delete(Long id);
}
