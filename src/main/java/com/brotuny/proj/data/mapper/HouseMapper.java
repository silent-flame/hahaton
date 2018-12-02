package com.brotuny.proj.data.mapper;

import com.brotuny.proj.data.model.House;
import org.apache.ibatis.annotations.*;

@Mapper
public interface HouseMapper {
    @Insert("INSERT INTO houses (id, number, house_complex_id, created_at, updated_at) " +
            "VALUES (#{id}, #{number}, #{complexId}, #{created_at}, #{updated_at})")
    @SelectKey(statement = "SELECT nextVal('houses_id_seq')", keyProperty = "id", before = true, resultType = long.class)
    void insert(House house);

    //@Results({@Result(property = "id", column = "Id")})
    @Select("SELECT id, number, house_complex_id as complexId FROM houses WHERE id = #{id}")
    House findById(@Param("id") long id);

    //@Results({@Result(property = "id", column = "Id")})
    @Select("SELECT id, number, house_complex_id as complexId FROM houses")
    House[] getAll();


    //@Results({@Result(property = "id", column = "Id")})
    @Select("SELECT id, number, house_complex_id as complexId FROM houses where house_complex_id = #{id}")
    House[] getAllAtComplex(@Param("id") long id);
}
