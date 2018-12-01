package com.brotuny.proj.data.mapper;

import com.brotuny.proj.data.model.Complex;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ComplexMapper {

    @Insert("INSERT INTO house_complexes (id, logo, name, address, developerId) VALUES (#{id}, #{logo}, #{name}, #{address}, #{developerId})")
    @SelectKey(statement = "SELECT nextVal('house_complexes_id_seq')", keyProperty = "id", before = true, resultType = long.class)
    void insert(Complex complex);

    //@Results({@Result(property = "id", column = "Id")})
    @Select("SELECT id, logo, name, address, developer_id as developerId FROM house_complexes WHERE id = #{id}")
    Complex findById(@Param("id") long id);

    //@Results({@Result(property = "id", column = "Id")})
    @Select("SELECT id, logo, name, address, developer_id as developerId FROM house_complexes")
    Complex[] getAll();

}
