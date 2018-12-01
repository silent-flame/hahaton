package com.brotuny.proj.service;

import com.brotuny.proj.data.model.Post;
import com.brotuny.proj.data.mapper.PostMapper;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostMapper postMapper;

    public PostService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public Post findPostById(long id) {
        return postMapper.findById(id);
    }


    public Post createPost(Post post) {
        if (findPostById(post.getPostId()) != null)
            throw new IllegalArgumentException(String.format("Post with id %s exists", post.getPostId()));
        postMapper.insert(post);
        return post;
    }

    public Post[] getAll() {
        return postMapper.getAll();
    }
}
