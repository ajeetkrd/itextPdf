package com.boot.app.service;

import com.boot.app.bean.City;

import java.util.List;

public interface ICityService {

    List<City> findAll();

    City add(City c);
}
