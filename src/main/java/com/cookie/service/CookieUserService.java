package com.cookie.service;

import com.cookie.dao.UserFilter;
import com.cookie.dao.user.IUserRepository;
import com.cookie.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieUserService implements ICookieUserService<User, UserFilter> {

    private final IUserRepository repository;

    @Autowired
    public CookieUserService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insert(User entity) {
        this.repository.insert(entity);
    }

    @Override
    public void update(User entity) {
        this.repository.update(entity);
    }

    @Override
    public void delete(long id) {
        this.repository.delete(id);
    }

    @Override
    public User findByCriteria(UserFilter criteria) {
        return this.repository.findByFilter(criteria);   //todo implement search by criteria
    }
}
