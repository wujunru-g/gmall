package com.wujunru.gmall.bean;

import java.io.Serializable;

public class PmsBasecatalog3 implements Serializable {
    private Long id;
    private String name;
    private Long catalog2_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCatalog2_id() {
        return catalog2_id;
    }

    public void setCatalog2_id(Long catalog2_id) {
        this.catalog2_id = catalog2_id;
    }

    @Override
    public String toString() {
        return "PmsBasecatalog3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", catalog2_id=" + catalog2_id +
                '}';
    }
}
