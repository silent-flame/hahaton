package com.brotuny.proj.data.mapper;

import com.brotuny.proj.data.model.Post;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PostMapper {

    @Insert("INSERT INTO post (post_id, title, preview, body) VALUES (#{postId}, #{title}, #{preview}, #{body})")
    @SelectKey(statement = "SELECT nextVal('post_sequence')", keyProperty = "postId", before = true, resultType = long.class)
    void insert(Post post);

    //@Results({@Result(property = "postId", column = "post_id")})
    @Select("SELECT post_id as postId, title, preview, body FROM Post WHERE post_id = #{post_id}")
    Post findById(@Param("post_id") long postId);

    //@Results({@Result(property = "postId", column = "post_id")})
    @Select("SELECT post_id as postId, title, preview, body FROM Post")
    Post[] getAll();
}
