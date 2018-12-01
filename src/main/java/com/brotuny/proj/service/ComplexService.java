package com.brotuny.proj.service;

import com.brotuny.proj.data.mapper.ComplexMapper;
import com.brotuny.proj.data.model.Complex;
import org.springframework.stereotype.Service;

@Service
public class ComplexService {

    private final ComplexMapper complexMapper;

    public ComplexService(ComplexMapper complexMapper) {
        this.complexMapper = complexMapper;
    }


    public Complex findComplexById(long id) {
        return complexMapper.findById(id);
    }


    public Complex createComplex(Complex complex) {
        if (findComplexById(complex.getId()) != null)
            throw new IllegalArgumentException(String.format("Complex with id %s exists", complex.getId()));
        complexMapper.insert(complex);
        return complex;
    }

    public Complex[] getAll() {
        return complexMapper.getAll();
    }
}
