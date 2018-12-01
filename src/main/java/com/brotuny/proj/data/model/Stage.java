package com.brotuny.proj.data.model;

import com.brotuny.proj.data.StageStatus;

import java.sql.Timestamp;

public class Stage extends BREntity {


    public Stage(long id, String title, Timestamp end_date, String photo, String description, long houseId, Timestamp created_at, Timestamp updated_at, int status) {
        this.id = id;
        this.title = title;
        this.photo = photo;
        this.description = description;
        this.houseId = houseId;
        this.end_date = end_date;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getHouseId() {
        return houseId;
    }

    public void setHouseId(long houseId) {
        this.houseId = houseId;
    }

    public Timestamp getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Timestamp end_date) {
        this.end_date = end_date;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private String title;
    private String photo;
    private String description;
    private long houseId;
    private Timestamp end_date;
    private Timestamp created_at;
    private Timestamp updated_at;
    private int status;

}
