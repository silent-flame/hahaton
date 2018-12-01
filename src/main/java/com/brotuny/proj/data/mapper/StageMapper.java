package com.brotuny.proj.data.mapper;

import com.brotuny.proj.data.model.Stage;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

@Mapper
public interface StageMapper {
    @Insert({"INSERT INTO stages (id, title, end_date, photo, description, house_id, created_at, updated_at, status ,position) " +
            "VALUES (#{id}, #{title}, #{end_date}, #{photo}, #{description}, #{houseId}, #{created_at}, #{updated_at}, #{status}, #{position})"})
    @SelectKey(statement = "SELECT nextVal('stages_id_seq')", keyProperty = "id", before = true, resultType = long.class)
    void insert(Stage stage);

    //@Results({@Result(property = "id", column = "Id")})
    @Select("SELECT id, title, end_date, photo, description, house_id as houseId, created_at, updated_at, status, position FROM stages WHERE id = #{id}")
    Stage findById(@Param("id") long id);

    //@Results({@Result(property = "id", column = "Id")})
    @Select("SELECT id, title, end_date, photo, description, house_id as houseId, created_at, updated_at, status, position FROM stages")
    Stage[] getAll();


    //@Results({@Result(property = "id", column = "Id")})
    @Select("SELECT id, title, end_date, photo, description, house_id as houseId, created_at, updated_at, status, position FROM stages where house_id = #{id}")
    Stage[] getAllAtHouse(@Param("id") long id);


    @Update("UPDATE stages SET " +
            " title = #{title}," +
            " end_date = #{end_date}," +
            " photo = #{photo}," +
            " description = #{description}," +
            " house_id = #{houseId}," +
            " created_at = #{created_at}," +
            " updated_at = #{updated_at}," +
            " status = #{status}," +
            " position = #{position}" +
            " WHERE id  = #{id}")
    void update(Stage stage);


    @Delete("DELETE FROM stages WHERE id = #{id}")
    void delete(@Param("id") long id);
}
