package io.pragra.learning.jpademo.service;

import io.pragra.learning.jpademo.domain.Author;
import io.pragra.learning.jpademo.domain.Book;
import io.pragra.learning.jpademo.exception.AuthorNotFoundException;
import io.pragra.learning.jpademo.exception.BookNotFoundException;
import io.pragra.learning.jpademo.repo.AuthorRepo;
import io.pragra.learning.jpademo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepo repo;
    @Autowired
    private AuthorRepo authRepo;

    public Book getBookById(Long id){
        Optional<Book> byId = this.repo.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }else {
            throw new BookNotFoundException("Not found Any Books");
        }
    }

    public List<Book> getAll(){
        return repo.findAll();
    }

    public Book createBook(@RequestBody Book book){
        Long id = book.getAuthor().getId();
        Optional<Author> author = authRepo.findById(id);
        if(!author.isPresent()){
            throw new AuthorNotFoundException("Author doesn't exist");
        }
        book.setAuthor(author.get());
        return repo.save(book);
    }

    public List<Book> getAllByPrice(double price){
        return repo.findAllByPrice(price);
    }
}
