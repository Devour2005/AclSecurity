package com.cookie.rest;

import com.cookie.dao.UserFilter;
import com.cookie.domain.User;
import com.cookie.service.ICookieUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Alexander Kuidin on 029 29.10.17.
 */
@Slf4j
@RestController("/raccoon")
public class CookieUserRestController {

    private final ICookieUserService<User, UserFilter> cookieUserService;

    @Autowired
    public CookieUserRestController(ICookieUserService<User, UserFilter> cookieUserService) {
        this.cookieUserService = cookieUserService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User insert(@RequestBody User user) {
        cookieUserService.insert(user);
        log.info("Insert user {}", user);
        return user;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User findByCriteria(@PathVariable("id") Long id) {
        User user = cookieUserService.findByCriteria(UserFilter.builder().id(id).build());
        log.info("Get user {}", user);
        return user;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {

        System.out.println("Updating user {}" + user.getFirstName() + " " + user.getLastName());
        User currentUser = cookieUserService.findByCriteria(UserFilter.builder().id(id).build());
        currentUser.setLogin(user.getLogin());
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setEmail(user.getEmail());
        currentUser.setEnabled(user.isEnabled());
        cookieUserService.update(currentUser);
        return currentUser;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id) {
        cookieUserService.delete(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String ping() {
        return "test rest";
    }
}
