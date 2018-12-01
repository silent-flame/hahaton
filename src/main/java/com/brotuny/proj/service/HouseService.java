package com.brotuny.proj.service;

import com.brotuny.proj.data.mapper.HouseMapper;
import com.brotuny.proj.data.model.House;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    private final HouseMapper househapper;

    public HouseService(HouseMapper househapper) {
        this.househapper = househapper;
    }

    public House findHouseById(long id) {
        return househapper.findById(id);
    }

    public House createHouse(House house) {
        if (findHouseById(house.getId()) != null)
            throw new IllegalArgumentException(String.format("House with id %s exists", house.getId()));
        househapper.insert(house);
        return house;
    }

    public House[] getAll() {
        return househapper.getAll();
    }

    public House[] findHousesByComplexId(long id) {
        return househapper.getAllAtComplex(id);
    }



}
