package com.saraf.myapp.controller;

import com.saraf.myapp.entity.Comments;
import com.saraf.myapp.service.CommentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private CommentService commentService;


    @PostMapping("/create")
    public ResponseEntity<Comments> saveComment(@Valid @RequestBody Comments comments){
        commentService.saveComment(comments);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/{post_id}/all")
    public ResponseEntity<Comments> getAllCommentsForPost(@Valid @PathVariable long post_id){
        return new ResponseEntity(commentService.getAllComments(post_id), HttpStatus.OK);
    }
}
