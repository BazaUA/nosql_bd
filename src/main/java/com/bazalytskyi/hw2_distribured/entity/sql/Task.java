package com.bazalytskyi.hw2_distribured.entity.sql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "task")
public class Task {
    @Id
    String name;
    @Column(name="base_sequence")
    String baseSequence;
    @Column(name="origin_start")
    Integer originStart;
    @Column(name="origin_end")
    Integer originEnd;
    Integer length;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseSequence() {
        return baseSequence;
    }

    public void setBaseSequence(String baseSequence) {
        this.baseSequence = baseSequence;
    }

    public Integer getOriginStart() {
        return originStart;
    }

    public void setOriginStart(Integer originStart) {
        this.originStart = originStart;
    }

    public Integer getOriginEnd() {
        return originEnd;
    }

    public void setOriginEnd(Integer originEnd) {
        this.originEnd = originEnd;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
