package com.saraf.myapp.repository;

import com.saraf.myapp.entity.Likes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LikesRepository extends CrudRepository<Likes, Long> {

    @Query(" SELECT l from Likes  l where l.user.id = :user_id and l.post.postId = :post_id")
    Likes checkTheLikeStatus(@Param("user_id") long user_id, @Param("post_id") long post_id);

    @Query(" select  count(l.id) from Likes l where  l.post.postId = :post_id")
    int countAllLikeForAPost(long post_id);

}
