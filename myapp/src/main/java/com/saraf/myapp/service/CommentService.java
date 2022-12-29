package com.saraf.myapp.service;

import com.saraf.myapp.entity.Comments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    Comments saveComment(Comments comments);
    List <Comments> getAllComments(long postId);
}
