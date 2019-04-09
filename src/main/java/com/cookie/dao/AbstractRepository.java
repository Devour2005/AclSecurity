package com.cookie.dao;

import com.cookie.dao.exception.RepositoryException;

import java.util.concurrent.Callable;

/**
 * Created by Alexander Kuidin on 029 29.10.17.
 */


public abstract class AbstractRepository {

    protected<T> T defaultErrorProcessing(Callable<T> toExec) throws RepositoryException {
        try {
            return toExec.call();
        } catch (Throwable e) {
            this.processError(e);
            return null;
        }
    }

    protected void processError(Throwable e) throws RepositoryException{
        if (e instanceof RepositoryException) {
            throw (RepositoryException) e;
        }
        throw new RepositoryException(e);
    }
}
