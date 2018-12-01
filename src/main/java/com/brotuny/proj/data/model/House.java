package com.brotuny.proj.data.model;

public class House extends BREntity {
    private String number;
    private long complexId;

    public House(long id, String number, long complexId) {
        this.id = id;
        this.number = number;
        this.complexId = complexId;
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
