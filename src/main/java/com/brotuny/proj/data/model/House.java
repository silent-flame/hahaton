package com.brotuny.proj.data.model;

import java.sql.Timestamp;

public class House extends BREntity {
    private String number;
    private long complexId;

    public House() {
    }

    public House(long id, String number, long complexId, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.number = number;
        this.complexId = complexId;
        this.created_at = created_at;
        this.updated_at = updated_at;//TODO to superclass
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getComplexId() {
        return complexId;
    }

    public void setComplexId(long complexId) {
        this.complexId = complexId;
    }


}
