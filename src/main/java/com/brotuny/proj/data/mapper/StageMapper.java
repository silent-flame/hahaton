package com.brotuny.proj.data.mapper;

import com.brotuny.proj.data.model.Stage;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StageMapper {
    @Insert("INSERT INTO stages (id, title, end_date, photo, description, house_id, created_at, updated_at, status ) " +
            "VALUES (#{id}, #{title}, #{end_date}, #{photo}, #{description}, #{house_id}, #{created_at}, #{updated_at}, #{status}")
    @SelectKey(statement = "SELECT nextVal('stages_id_seq')", keyProperty = "id", before = true, resultType = long.class)
    void insert(Stage house);

    //@Results({@Result(property = "id", column = "Id")})
    @Select("SELECT id, title, end_date, photo, description, house_id, created_at, updated_at, status FROM stages WHERE id = #{id}")
    Stage findById(@Param("id") long id);

    //@Results({@Result(property = "id", column = "Id")})
    @Select("SELECT * FROM stages")
    Stage[] getAll();


    //@Results({@Result(property = "id", column = "Id")})
    @Select("SELECT * FROM stages where house_id = #{id}")
    Stage[] getAllAtHouse(@Param("id") long id);
}
