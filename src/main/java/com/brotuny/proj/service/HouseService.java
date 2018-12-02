package com.brotuny.proj.service;

import com.brotuny.proj.data.mapper.HouseMapper;
import com.brotuny.proj.data.model.House;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    private final HouseMapper househapper;
    private final TimeService timeService;

    public HouseService(HouseMapper househapper, TimeService timeService) {
        this.househapper = househapper;
        this.timeService = timeService;
    }

    public House findHouseById(long id) {
        return househapper.findById(id);
    }

    public House createHouse(House house) {
        if (findHouseById(house.getId()) != null)
            throw new IllegalArgumentException(String.format("House with id %s exists", house.getId()));
        timeService.setTime(house);
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
