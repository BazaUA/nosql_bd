package com.bazalytskyi.hw2_distribured.entity.sql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity(name = "base_region")
public class BaseRegion {
    @Id
    private String name;
    @ManyToMany(mappedBy = "regions")
    private List<Base> bases;
    @ManyToMany(mappedBy = "regions")
    private List<RegionGroup> regionGroups;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Base> getBases() {
        return bases;
    }

    public void setBases(List<Base> bases) {
        this.bases = bases;
    }

    public List<RegionGroup> getRegionGroups() {
        return regionGroups;
    }

    public void setRegionGroups(List<RegionGroup> regionGroups) {
        this.regionGroups = regionGroups;
    }
}
