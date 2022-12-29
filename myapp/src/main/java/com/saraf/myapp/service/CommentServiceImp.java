package com.saraf.myapp.service;

import com.saraf.myapp.entity.Comments;
import com.saraf.myapp.repository.CommentRepository;
import com.saraf.myapp.repository.PostRepository;
import com.saraf.myapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class CommentServiceImp implements CommentService {

    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;

    @Override
    public Comments saveComment(Comments comments) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        comments.setUser(userRepository.findByUsername(authentication.getName()).get());
        comments.setCreatedAt(LocalDateTime.now());
        return commentRepository.save(comments);
    }


    @Override
    public List<Comments> getAllComments(long postId) {
        return (List<Comments>) commentRepository.getAllCommentsForOnePost(postId);
    }

}
