package com.brotuny.proj.service;

import com.brotuny.proj.data.mapper.StageMapper;
import com.brotuny.proj.data.model.Stage;
import com.brotuny.proj.notifications.SmtpEmailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class StageService {

    private final StageMapper stageMapper;
    private final SmtpEmailSender smtpEmailSender;
    private final TimeService timeService;

    public StageService(StageMapper stageMapper, SmtpEmailSender smtpEmailSender, TimeService timeService) {
        this.stageMapper = stageMapper;
        this.smtpEmailSender = smtpEmailSender;
        this.timeService = timeService;
    }

    public Stage findStageById(long id) {
        return stageMapper.findById(id);
    }

    public Stage createStage(Stage stage) {
        if (findStageById(stage.getId()) != null)
            throw new IllegalArgumentException(String.format("Stage with id %s exists", stage.getId()));
        timeService.setTime(stage);
        stageMapper.insert(stage);
        return stage;
    }

    public Stage[] getAll() {
        return stageMapper.getAll();
    }

    public Stage[] findStagesByHouseId(long id) {
        List<Stage> stages = Arrays.asList(stageMapper.getAllAtHouse(id));
        stages.sort(Comparator.comparingInt(Stage::getPosition));

        return stages.toArray(new Stage[stages.size()]);
    }

    public Stage update(Stage stage) {
        Stage oldStage = stageMapper.findById(stage.getId());
        actualyze(stage, oldStage);
        stage.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        stageMapper.update(stage);

        if (stage.getStatus() != oldStage.getStatus()) {
            smtpEmailSender.sendEmail(stage);
        }

        return stage;
    }

    public void update(Stage[] stages) {
        for (Stage stage : stages) {
            update(stage);
        }
    }

    public void deleteById(long id) {
        stageMapper.delete(id);
    }

    private void actualyze(Stage newStage, Stage oldStage) {
        ReflectionUtils.doWithFields(newStage.getClass(), field -> {
            /*switch (field.getType()){}*/
            field.setAccessible(true);

            if (field.getType().equals(long.class)) {
                if ((long) field.get(newStage) != 0) {
                    return;
                }
            } else if (field.getType().equals(int.class)) {
                if ((int) field.get(newStage) != 0) {
                    return;
                }
            } else if (field.getType().equals(String.class)) {
                if (!StringUtils.isEmpty(field.get(newStage))) {
                    return;
                }
            } else if (field.getType().equals(Timestamp.class)) {
                if (field.get(newStage) != null) {
                    return;
                }
            } else {
                throw new IllegalArgumentException("type : " + field.getType());
            }
            field.set(newStage, field.get(oldStage));
        });
    }


}
