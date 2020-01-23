package com.boot.app.service;

import com.boot.app.bean.City;
import com.boot.app.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> findAll() {

        List<City> cities = (List<City>) repository.findAll();

        return cities;
    }

    @Override
    public City add(City c) {
        repository.save(c);
        return repository.findOne(c.getId());
    }
}
