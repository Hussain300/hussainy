package com.saraf.myapp.service;

import com.auth0.jwt.JWT;
import com.saraf.myapp.entity.Post;
import com.saraf.myapp.entity.User;
import com.saraf.myapp.exception.EntityNotFoundException;
import com.saraf.myapp.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostServiceImp implements PostService {

    // dependency injection
    private PostRepository postRepository;
    private UserService userService;

    @Override
    public Post savePost(Post post) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.getUser(username);
        post.setUser(user);

        //setting the created date and time of post
        LocalDateTime createdAt =  LocalDateTime.now();
        post.setCreatedAt(createdAt);
        return postRepository.save(post);
    }


    public Post getPost(long id) {
        Optional <Post> post = postRepository.findById(id);
        return unwrapPost(post, id);
    }

    @Override
    public List<Post> getPosts() {
        return ( List<Post>) postRepository.findAll() ;
    }

    public static Post unwrapPost(Optional <Post> entity, long id){
        if (entity.isPresent()){
            return entity.get();
        }else {
            throw new EntityNotFoundException(id, Post.class);
        }
    }
}
