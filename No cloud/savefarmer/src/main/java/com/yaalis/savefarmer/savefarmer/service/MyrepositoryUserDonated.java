package com.yaalis.savefarmer.savefarmer.service;

import org.springframework.data.repository.CrudRepository;

import com.yaalis.savefarmer.savefarmer.bean.UserBean;

public interface MyrepositoryUserDonated extends CrudRepository<UserBean, String>{

}
