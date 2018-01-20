package com.yaalis.savefarmer.savefarmer.service;

import org.springframework.data.repository.CrudRepository;

import com.yaalis.savefarmer.savefarmer.bean.FarmerBean;

public interface MyrepositoryFarmerBean extends CrudRepository<FarmerBean, String> {

}
