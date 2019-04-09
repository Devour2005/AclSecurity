package com.cookie.service;

import com.cookie.dao.UserFilter;
import com.cookie.domain.User;

import java.util.*;

public interface ICookieUserService<USER extends User, FILTER extends UserFilter> {
    void insert(USER entity);

    void update(USER entity);

    void delete(long id);

    USER findByCriteria(FILTER filter); //todo implement search by criteria
}
