package com.theory.jpa.domain;

import javax.persistence.*;

public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "family_id")
    private String id;

    @Column(length = 100)
    private String description;

    public Family(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;
}
