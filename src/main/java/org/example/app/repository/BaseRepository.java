package org.example.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;



public interface BaseRepository <T>{
    void create(T entity);

    Optional<Map<Long,T>> getAll();

    T getById(Long id);

    boolean update(Long id, T entity);

    boolean delete(Long id);
}
