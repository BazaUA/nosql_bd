package com.bazalytskyi.hw2_distribured.entity.sql;

import javax.persistence.*;
import java.util.List;

@Entity(name = "base")
public class Base {
    @Id
    private String source;

    private Integer population;
    @ManyToOne
    @JoinColumn(name="task_name")
    private Task taskName;
    @ManyToMany
    @JoinTable(
            name = "base_has_base_region",
            joinColumns = @JoinColumn(name = "base_source"),
            inverseJoinColumns = @JoinColumn(name = "base_region_name")
    )
    private List<BaseRegion> regions;
    private String sequence;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Task getTaskName() {
        return taskName;
    }

    public void setTaskName(Task taskName) {
        this.taskName = taskName;
    }

    public List<BaseRegion> getRegions() {
        return regions;
    }

    public void setRegions(List<BaseRegion> regions) {
        this.regions = regions;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}
