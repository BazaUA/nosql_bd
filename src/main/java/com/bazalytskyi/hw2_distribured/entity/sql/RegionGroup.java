package com.bazalytskyi.hw2_distribured.entity.sql;

import javax.persistence.*;
import java.util.List;

@Entity(name = "region_group") // This tells Hibernate to make a table out of this class
public class RegionGroup {
	@Id
	private String name;
	private String wild_sequence;

	@ManyToMany
	@JoinTable(
			name = "region_group_has_base_region",
			joinColumns = @JoinColumn(name = "region_group_name"),
			inverseJoinColumns = @JoinColumn(name = "base_region_name")
	)
	private List<BaseRegion> regions;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BaseRegion> getRegions() {
		return regions;
	}

	public void setRegions(List<BaseRegion> regions) {
		this.regions = regions;
	}

	public String getWild_sequence() {
		return wild_sequence;
	}

	public void setWild_sequence(String wild_sequence) {
		this.wild_sequence = wild_sequence;
	}
}
