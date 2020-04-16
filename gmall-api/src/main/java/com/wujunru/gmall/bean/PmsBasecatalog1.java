package com.wujunru.gmall.bean;

import java.io.Serializable;
import java.util.List;

public class PmsBasecatalog1 implements Serializable {
    private Integer id;
    private String  name;

    private List<PmsBasecatalog2> pmsBasecatalog2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PmsBasecatalog2> getPmsBasecatalog2() {
        return pmsBasecatalog2;
    }

    public void setPmsBasecatalog2(List<PmsBasecatalog2> pmsBasecatalog2) {
        this.pmsBasecatalog2 = pmsBasecatalog2;
    }

    @Override
    public String toString() {
        return "PmsBasecatalog1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pmsBasecatalog2=" + pmsBasecatalog2 +
                '}';
    }
}
