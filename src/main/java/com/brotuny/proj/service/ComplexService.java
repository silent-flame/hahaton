package com.brotuny.proj.service;

import com.brotuny.proj.data.mapper.ComplexMapper;
import com.brotuny.proj.data.model.Complex;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ComplexService {

    private final ComplexMapper complexMapper;
    private final TimeService timeService;

    public ComplexService(ComplexMapper complexMapper, TimeService timeService) {
        this.complexMapper = complexMapper;
        this.timeService = timeService;
    }


    public Complex findComplexById(long id) {
        return complexMapper.findById(id);
    }


    public Complex createComplex(Complex complex) {
        if (findComplexById(complex.getId()) != null)
            throw new IllegalArgumentException(String.format("Complex with id %s exists", complex.getId()));
        timeService.setTime(complex);
        complexMapper.insert(complex);
        return complex;
    }

    public Complex[] getAll() {
        return complexMapper.getAll();
    }
}
