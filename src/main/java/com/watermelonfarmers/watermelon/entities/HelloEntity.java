package com.watermelonfarmers.watermelon.entities;

import javax.persistence.Entity;

@Entity
public class HelloEntity {

    @javax.persistence.Id
    private long Id;
    private String name;
    private String greeting;

    public HelloEntity(long id, String name, String greeting) {
        Id = id;
        this.name = name;
        this.greeting = greeting;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
