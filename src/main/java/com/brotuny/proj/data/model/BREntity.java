package com.brotuny.proj.data.model;

import java.io.Serializable;
import java.sql.Timestamp;

public abstract class BREntity implements Serializable {

    public BREntity(){

    }

    // @Getter@Setter
    protected long id;
    protected Timestamp created_at;
    protected Timestamp updated_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

}
