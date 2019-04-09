package com.cookie.dao;

public interface IRepository<T, F> {

    void insert(T entity);

    void update(T entity);

    void delete(long id);

    T findByFilter(F filter);
}
