package com.bazalytskyi.hw2_distribured.repository.sql;


import com.bazalytskyi.hw2_distribured.entity.sql.Base;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository extends CrudRepository<Base, String> {

}
