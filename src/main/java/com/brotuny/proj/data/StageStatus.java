package com.brotuny.proj.data;

import java.io.Serializable;

public enum StageStatus implements Serializable {

    NOT_STARTED(0),
    IN_PROGRES(1),
    COMPLETED(2);

    private int value;

    StageStatus(final int value) {
        this.value = value;
    }

    public static StageStatus valueOf(int statusId) {
        for (StageStatus status : values()) {
            if (status.value == statusId) {
                return status;
            }
        }
        throw new IllegalStateException("There are not StageStatus with value " + statusId);
    }

}
