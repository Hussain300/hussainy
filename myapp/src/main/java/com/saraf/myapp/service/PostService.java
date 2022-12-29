package com.saraf.myapp.service;

import com.saraf.myapp.entity.Post;

import java.util.List;

public interface PostService {
    Post savePost(Post post);
    Post getPost(long id);
    List<Post> getPosts();

    void updatePost(long id, Post post);
    void deletePost(long id);

    void deleteAllPosts();

}
