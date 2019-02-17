package com.watermelonfarmers.watermelon.entities;

import javax.persistence.*;

@Entity
@Table(name = "REQUIREMENT")
public class RequirementEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
