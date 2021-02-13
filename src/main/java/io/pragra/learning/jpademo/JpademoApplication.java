package io.pragra.learning.jpademo;

import io.pragra.learning.jpademo.domain.Author;
import io.pragra.learning.jpademo.domain.Book;
import io.pragra.learning.jpademo.domain.RefData;
import io.pragra.learning.jpademo.domain.StatusEnum;
import io.pragra.learning.jpademo.repo.AuthorRepo;
import io.pragra.learning.jpademo.repo.BookRepo;
import io.pragra.learning.jpademo.repo.RefDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class JpademoApplication {
    @Autowired
    private BookRepo repo;
    @Autowired
    private AuthorRepo authRepo;
    @Autowired
    private RefDataRepo refDataRepo;

    public static void main(String[] args) {

        SpringApplication.run(JpademoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            Author auth1 = new Author("Ronaldo","Juventus","Italy",new Date(),new Date(), StatusEnum.ACTIVE);
            authRepo.save(auth1);
            Author auth2 = new Author("Messi","BArcelona","Spain",new Date(),new Date(), StatusEnum.ACTIVE);
            authRepo.save(auth2);
            Author auth3 = new Author("Jose","Spurs","Uk",new Date(),new Date(), StatusEnum.ACTIVE);
            authRepo.save(auth3);
            Author auth4 = new Author("Pep","ManCity","Uk",new Date(),new Date(), StatusEnum.ACTIVE);
            authRepo.save(auth4);
            Book book = new Book(1122331L,"Learning Java",auth1,"Programming",300);
            Book save = repo.save(book);
            System.out.println(save);
            Book book2 = new Book(1122332L,"Learning Angular",auth2,"pragramming",200);
            repo.save(book2);
            repo.findAll();
            repo.findById(2L).ifPresent(System.out:: println);;
            repo.save(new Book(1122333L,"Learning Angular",auth3,"Programming",150));
            repo.save(new Book(1122334L,"Learning Cry",auth4,"Programming",150));
            System.out.println( repo.findByPriceOrderByIsbn(150));
            System.out.println(repo.countAll());

            refDataRepo.save(new RefData("Apple", "Fruit"));
            refDataRepo.save(new RefData("Orange", "Fruit"));

        };
    }

}
