package com.saraf.myapp.service;

import com.saraf.myapp.entity.Likes;
import com.saraf.myapp.entity.User;
import com.saraf.myapp.helper_classes.NumberOfLikes;
import com.saraf.myapp.repository.LikesRepository;
import com.saraf.myapp.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor

public class LikesServiceImp implements LikesService{
    private LikesRepository likesRepository;
    private UserService userService;
    private PostRepository postRepository;
    private NumberOfLikes numberOfLikes;

    @Override
    public NumberOfLikes saveLike(long id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.getUser(username);
        long user_id = user.getId();
        if ( likesRepository.checkTheLikeStatus(user_id, id) == null ){

            likesRepository.save(new Likes( user, postRepository.findById(id).get()));
        }else {
            likesRepository.delete(likesRepository.checkTheLikeStatus(user_id, id));
        }
        return  new NumberOfLikes(id, likesRepository.countAllLikeForAPost(id));
    }


}
