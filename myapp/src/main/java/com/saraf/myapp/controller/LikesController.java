package com.saraf.myapp.controller;

import com.saraf.myapp.entity.Likes;
import com.saraf.myapp.helper_classes.NumberOfLikes;
import com.saraf.myapp.service.LikesService;
import com.saraf.myapp.service.PostService;
import com.saraf.myapp.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/likes")
public class LikesController {
    private PostService postService;
    private UserService userService;
    private LikesService likesService;

    @GetMapping("/{post_id}/like")
    public ResponseEntity <NumberOfLikes> likeAPost(@Valid @PathVariable long post_id){
        return new ResponseEntity<>(likesService.saveLike(post_id) , HttpStatus.ACCEPTED);
    }
}
