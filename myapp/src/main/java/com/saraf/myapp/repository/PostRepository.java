package com.saraf.myapp.repository;

import com.saraf.myapp.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}
