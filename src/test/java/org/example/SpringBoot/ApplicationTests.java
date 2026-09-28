package org.example.SpringBoot;

import org.example.SpringBoot.Models.Author;
import org.example.SpringBoot.Repositories.AuthorRepositories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.example.SpringBoot.Models.Comment;
import org.example.SpringBoot.Models.Post;
import org.example.SpringBoot.Repositories.CommentRepository;
import org.example.SpringBoot.Repositories.PostRepository;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ApplicationTests {


    @Autowired
    AuthorRepositories authorRepositories;

      @Autowired
      CommentRepository commentRepositories;

    @Autowired
    PostRepository postRepositories;

    @BeforeEach
    void load() {
        Author a1 = new Author();
        a1.setName("Giuseppe");
        a1.setSurname("Verdi");
         a1.setEmail("VerdiG@test.it");
         authorRepositories.save(a1);

        Post p1 = new Post();
        p1.setTitle("Caso rogiero");
        p1.setBody("Un breve riassunto della vicenda di caso rogiero");
          p1.setPublishDate("20260101");
          p1.setAuthor(a1);
        postRepositories.save(p1);

           Comment c1 = new Comment();
           c1.setEmail("utente@gmail.com");
           c1.setBody("Bellissimo articolo!");
        c1.setDate("20260101");
        c1.setPost(p1);
        commentRepositories.save(c1);
    }


    @Test
    void contextLoads() {
    }

    @Test
    void findByName() {


        assertThat(authorRepositories.findByName("Giuseppe"))

                .extracting("name")

                .containsOnly("Giuseppe");
    }

    @Test
    void findByTitle(){
        assertThat(postRepositories.findByTitle("Caso rogiero"))
                .extracting("title")
                .containsOnly("Caso rogiero");
    }

    @Test
    void findByEmail(){
        assertThat(commentRepositories.findByEmail("utente@gmail.com"))
                .extracting("email")
                .containsOnly("utente@gmail.com");
    }

    @Test
    void authorsWithSameName() {
        assertThat(authorRepositories.authorsWithSameName())
                .extracting("name")
                .contains("Giuseppe");
    }

    @Test
    void commentoMetodo() {
        assertThat(commentRepositories.commentoMetodo())
                .extracting("email")
                .contains("utente@gmail.com");
    }

    @Test
    void metodoPost() {
        assertThat(postRepositories.metodoPost())
                .extracting("title")
                .contains("Caso rogiero");
    }
}
