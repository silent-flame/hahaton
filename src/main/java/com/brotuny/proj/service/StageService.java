package com.brotuny.proj.service;

import com.brotuny.proj.data.mapper.StageMapper;
import com.brotuny.proj.data.model.Stage;
import org.springframework.stereotype.Service;

@Service
public class StageService {

    private final StageMapper stageMapper;

    public StageService(StageMapper stageMapper) {
        this.stageMapper = stageMapper;
    }

    public Stage findStageById(long id) {
        return stageMapper.findById(id);
    }

    public Stage createStage(Stage stage) {
        if (findStageById(stage.getId()) != null)
            throw new IllegalArgumentException(String.format("Stage with id %s exists", stage.getId()));
        stageMapper.insert(stage);
        return stage;
    }

    public Stage[] getAll() {
        return stageMapper.getAll();
    }

    public Stage[] findStagesByHouseId(long id) {
        return stageMapper.getAllAtHouse(id);
    }



}
