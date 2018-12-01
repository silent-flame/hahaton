package com.brotuny.proj.data.model;

import lombok.Getter;
import lombok.Setter;

public class Complex extends BREntity {


    // @Getter@Setter
    private String logo;
    // @Getter@Setter
    private String name;
    //@Getter@Setter
    private String address;
    // @Getter@Setter
    private long developerId;

    public Complex(long id, String logo, String name, String address, long developerId) {
        this.id = id;
        this.logo = logo;
        this.name = name;
        this.address = address;
        this.developerId = developerId;
    }


    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(long developerId) {
        this.developerId = developerId;
    }

}
