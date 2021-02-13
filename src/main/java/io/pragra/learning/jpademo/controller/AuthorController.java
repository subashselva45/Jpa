package io.pragra.learning.jpademo.controller;

import io.pragra.learning.jpademo.domain.Author;
import io.pragra.learning.jpademo.domain.Book;
import io.pragra.learning.jpademo.domain.ErrorResponse;
import io.pragra.learning.jpademo.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags="Author")
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    private AuthorService service;
    @GetMapping("/{id}")
    public Author getById(@PathVariable Long id){
        return service.findAuthorById(id);
    }
    @ApiResponses( {
            @ApiResponse(code=201,message="Created",response = Author.class),
            @ApiResponse(code=400, message="BadRequest", response= ErrorResponse.class)

    })
    @GetMapping
    public List<Author> getAllAuthors(){
        return service.getAllAuthors();
    }
    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return service.createAuthor(author);
    }

}
