package com.brotuny.proj.data.model;

import java.io.Serializable;

public abstract class BREntity implements Serializable {

    // @Getter@Setter
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
