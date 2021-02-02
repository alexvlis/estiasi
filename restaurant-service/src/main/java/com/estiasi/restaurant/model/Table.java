package com.estiasi.restaurant.model;

import com.estiasi.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tables")
public class Table extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String code;
    private Integer capacity;
    private String zone;
    private Date created;
    private Date updated;
    private Boolean smoking;
    private Boolean outdoor;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
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

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Boolean getSmoking() {
        return smoking;
    }

    public void setSmoking(Boolean smoking) {
        this.smoking = smoking;
    }

    public Boolean getOutdoor() {
        return outdoor;
    }

    public void setOutdoor(Boolean outdoor) {
        this.outdoor = outdoor;
    }

    @PrePersist
    public void onCreate() {
        created = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        updated = new Date();
    }

}
