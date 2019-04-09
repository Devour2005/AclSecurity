package com.cookie.dao;

import java.io.Serializable;

/**
 * Created by Alexander Kuidin on 029 29.10.17.
 */


public abstract class AbstractDbManagerRepository<T extends Serializable, F extends IFilter>
        extends AbstractRepository implements IRepository<T, F> {

    //todo make realisation for any type. (Hybernate)

    @Override
    public void insert(T entity) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public T findByFilter(F filter) {
        return null;
    }
}
