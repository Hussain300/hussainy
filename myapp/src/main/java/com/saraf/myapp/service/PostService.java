package com.saraf.myapp.service;

import com.saraf.myapp.entity.Post;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;

import java.util.List;

public interface PostService {
    Post savePost(Post post);
    Post getPost(long id);
    List<Post> getPosts();

}
