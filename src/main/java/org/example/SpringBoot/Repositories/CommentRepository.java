package org.example.SpringBoot.Repositories;

import org.example.SpringBoot.Models.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CommentRepository extends CrudRepository<Comment, Long> {


    List<Comment> findByEmail(String email);
    @Query(value = "SELECT * FROM comments WHERE email = 'utente@gmail.com'", nativeQuery = true)
    List<Comment> commentoMetodo();



}
