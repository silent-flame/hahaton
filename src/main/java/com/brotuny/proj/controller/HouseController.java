package com.brotuny.proj.controller;

import com.brotuny.proj.data.model.House;
import com.brotuny.proj.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @PostMapping
    @ResponseBody
    public House create(@RequestBody House complex) {
        House newComplex = houseService.createHouse(complex);
        return newComplex;
    }

    @GetMapping
    @ResponseBody
    public House[] getAll() {
        return  houseService.getAll();
    }

    @GetMapping(path="/{id}")
    @ResponseBody
    public House getById(@PathVariable("id")long id) {
        return  houseService.findHouseById(id);
    }

    @GetMapping(path="/complex/{id}")
    @ResponseBody
    public House[] getByComplexId(@PathVariable("id")long id) {
        return  houseService.findHousesByComplexId(id);
    }

}
