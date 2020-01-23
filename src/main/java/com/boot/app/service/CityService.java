package com.boot.app.service;

import com.boot.app.bean.City;
import com.boot.app.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {


    private CityRepository repository;

    @Autowired
    private void setRepository(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<City> findAll() {


        return (List<City>) repository.findAll();
    }

    @Override
    public City add(City c) {
        repository.save(c);
        return repository.findOne(c.getId());
    }
}
