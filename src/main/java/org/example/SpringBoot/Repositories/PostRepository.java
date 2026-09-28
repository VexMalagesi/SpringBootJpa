package org.example.SpringBoot.Repositories;

import org.example.SpringBoot.Models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findByTitle(String title);

    @Query(value = "SELECT * FROM posts WHERE title = 'Caso rogiero' ", nativeQuery = true)

    List<Post> metodoPost();






}
