package io.pragra.learning.jpademo.service;

import io.pragra.learning.jpademo.domain.Author;
import io.pragra.learning.jpademo.exception.AuthorNotFoundException;
import io.pragra.learning.jpademo.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepo authRepo;

    public List<Author> getAllAuthors(){
         return authRepo.findAll();
    }

    public Author findAuthorById(Long id){
       Optional<Author> byId = this.authRepo.findById(id);
      if(byId.isPresent()){
          return byId.get();
      }
      throw new AuthorNotFoundException("Author doen't exist");
    }

    public Author createAuthor(@RequestBody Author author){
        return authRepo.save(author);
    }
}
