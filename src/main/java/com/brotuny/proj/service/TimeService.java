package com.brotuny.proj.service;

import com.brotuny.proj.data.model.BREntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class TimeService {

    public void setTime(BREntity entity) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        entity.setCreated_at(now);
        entity.setUpdated_at(now);
    }
}
