package com.brotuny.proj.controller;

import com.brotuny.proj.data.model.Stage;
import com.brotuny.proj.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/stage")
public class StageController {

    @Autowired
    private StageService stageService;

    @PostMapping
    @ResponseBody
    public Stage create(@RequestBody Stage stage) {
        Stage newStage = stageService.createStage(stage);
        return newStage;
    }

    @GetMapping
    @ResponseBody
    public Stage[] getAll() {
        return stageService.getAll();
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public Stage getById(@PathVariable("id") long id) {
        Stage stage = stageService.findStageById(id);
        return stage;
    }

    @GetMapping(path = "/house/{id}")
    @ResponseBody
    public Stage[] getByComplexId(@PathVariable("id") long id) {
        return stageService.findStagesByHouseId(id);
    }


    @PatchMapping
    @ResponseBody
    public Stage update(@RequestBody Stage stage) {
        Stage updatedStage = stageService.update(stage);
        return updatedStage;
    }

   @PatchMapping("/bulk")
   @ResponseBody
    public ResponseEntity updateBulk(@RequestBody Stage[]  stage) {
        stageService.update(stage);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity deleteById(@PathVariable("id") long id) {
        stageService.deleteById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
