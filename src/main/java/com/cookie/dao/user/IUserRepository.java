package com.cookie.dao.user;

import com.cookie.dao.IRepository;
import com.cookie.dao.UserFilter;
import com.cookie.domain.User;

public interface IUserRepository extends IRepository<User, UserFilter>
{
}
