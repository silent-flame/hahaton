package com.brotuny.proj.controller;

import com.brotuny.proj.data.model.Complex;
import com.brotuny.proj.service.ComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/complex")
public class ComplexController {

    @Autowired
    private ComplexService complexService;

    @PostMapping
    @ResponseBody
    public Complex create(@RequestBody Complex complex) {
        Complex newComplex = complexService.createComplex(complex);
        return newComplex;
    }

    @GetMapping
    @ResponseBody
    public Complex[] getAll() {
        return  complexService.getAll();
    }

    @GetMapping(path="/{id}")
    @ResponseBody
    public Complex getById(@PathVariable("id")long id) {
        return  complexService.findComplexById(id);
    }

}
