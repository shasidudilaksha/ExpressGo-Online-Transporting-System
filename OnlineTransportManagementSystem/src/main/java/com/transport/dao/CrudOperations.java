package com.transport.dao;

import java.util.List;

public interface CrudOperations<T> {
    boolean insert(T obj);
    boolean update(T obj);
    boolean delete(int id);
    T getById(int id);
    List<T> getAll();
}
