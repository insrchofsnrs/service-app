package com.systp.serviceapp.services;

import com.systp.serviceapp.pojos.User;

import java.util.List;

public interface IUserService extends IService<User> {
    List<User> getPersons();

    User create(User person);

    void delete(User person);

    User findByLogin(String login);
}
