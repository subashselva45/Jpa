package io.pragra.learning.jpademo.controller;

import io.pragra.learning.jpademo.domain.Book;
import io.pragra.learning.jpademo.domain.ErrorResponse;
import io.pragra.learning.jpademo.repo.BookRepo;
import io.pragra.learning.jpademo.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags="Book")
@RequestMapping("/api/book")
public class BookController {
    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // @RequestMapping(value="/book",method = RequestMethod.GET)
    @GetMapping
    public List<Book> getAll(@RequestParam(value="price", required = false) Double price) {
        if (price == null) {
            return service.getAll();
        }
        return service.getAllByPrice(price);
    }
    @ApiResponses( {
            @ApiResponse(code=201,message="Created",response =Book.class),
            @ApiResponse(code=400, message="BadRequest", response= ErrorResponse.class)

    })
    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id){
        return service.getBookById(id);
    }
   // @RequestMapping(value = "/book",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @PostMapping
    public Book createBook(@RequestBody Book book){
        return service.createBook(book);
    }
   // @RequestMapping(value = "/book",method = RequestMethod.PUT,consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @PutMapping
    public Book updateBook(@RequestBody Book book){
        return service.createBook(book);
    }
    //@RequestMapping(value = "/book",method = RequestMethod.DELETE,consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    @DeleteMapping()
//    public void deleteBook(@RequestBody Book book){
//         repo.save(book);
//    }
}
