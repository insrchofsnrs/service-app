package com.systp.serviceapp.dao;

import com.systp.serviceapp.pojos.User;

import java.util.List;

public interface IUserDao extends Dao<User> {

    List<User> getPersons();

    User findByLogin(String login);

}
