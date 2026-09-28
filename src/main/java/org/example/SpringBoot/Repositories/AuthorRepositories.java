package org.example.SpringBoot.Repositories;

import org.example.SpringBoot.Models.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AuthorRepositories extends CrudRepository<Author, Long> {


    List<Author> findByName(String firstname);

    List<Author> findBySurname(String surname);

    List<Author> findByNameAndSurname(String firstname, String surname);

    @Query(value = "SELECT * FROM authors a WHERE a.firstname = 'Giuseppe'", nativeQuery = true)
    List<Author> authorsWithSameName();
}
