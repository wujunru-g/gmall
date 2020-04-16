package com.wujunru.gmall.bean;

import java.io.Serializable;
import java.util.List;

public class PmsBasecatalog2  implements Serializable {
    private Integer id;
    private String name;
    private Integer catalog1_id;
    private List<PmsBasecatalog3> pmsBasecatalog3;

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

    public Integer getCatalog1_id() {
        return catalog1_id;
    }

    public void setCatalog1_id(Integer catalog1_id) {
        this.catalog1_id = catalog1_id;
    }

    public List<PmsBasecatalog3> getPmsBasecatalog3() {
        return pmsBasecatalog3;
    }

    public void setPmsBasecatalog3(List<PmsBasecatalog3> pmsBasecatalog3) {
        this.pmsBasecatalog3 = pmsBasecatalog3;
    }

    @Override
    public String toString() {
        return "PmsBasecatalog2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", catalog1_id=" + catalog1_id +
                ", pmsBasecatalog3=" + pmsBasecatalog3 +
                '}';
    }
}
