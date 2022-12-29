package com.saraf.myapp.repository;

import com.saraf.myapp.entity.Comments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comments, Long> {
    @Query("select c from Comments  c where c.post.postId = :id")
    List<Comments> getAllCommentsForOnePost(@Param("id") long id);

}
