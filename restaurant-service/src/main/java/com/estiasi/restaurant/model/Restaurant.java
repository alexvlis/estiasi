package com.estiasi.restaurant.model;

import com.estiasi.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "restaurants")
public class Restaurant extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private Date created;
    private Date updated;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private List<Table> tables = new ArrayList<>();

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", columnDefinition = "DATETIME")
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", columnDefinition = "DATETIME")
    public Date getUpdated() {
        return updated;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    @Transient
    @JsonIgnore
    @PrePersist
    public void onCreate() {
        created = new Date();
    }

    @Transient
    @JsonIgnore
    @PreUpdate
    public void onUpdate() {
        updated = new Date();
    }

}
