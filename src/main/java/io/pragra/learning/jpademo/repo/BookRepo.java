package io.pragra.learning.jpademo.repo;

import io.pragra.learning.jpademo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {

    //List<Book> findAllPrice(double price);
    //List<Book> findByPrice(double price);
    List<Book> findByPriceOrderByIsbn(double price);

    @Query(value="select count(*) from table_book",nativeQuery = true)
    long countAll();

    List<Book> findAllByPrice(double price);}
