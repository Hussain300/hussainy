package com.saraf.myapp.service;


import com.saraf.myapp.entity.Likes;
import com.saraf.myapp.helper_classes.NumberOfLikes;

public interface LikesService {
    NumberOfLikes saveLike(long id);
}
