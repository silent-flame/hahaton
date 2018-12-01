package com.brotuny.proj.data.model;


import java.io.Serializable;


public class Post implements Serializable {

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", preview='" + preview + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    private long postId;
    private String title;
    private String preview;
    private String body;

    public Post() {
    }

    public Post(long postId, String title, String preview, String body) {
        this.postId = postId;
        this.title = title;
        this.preview = preview;
        this.body = body;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
