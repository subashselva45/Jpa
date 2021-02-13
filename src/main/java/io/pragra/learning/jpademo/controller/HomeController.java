package io.pragra.learning.jpademo.controller;

import io.pragra.learning.jpademo.domain.Book;
import io.pragra.learning.jpademo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private BookRepo repo;

    @GetMapping("/")
    public String getHome(Model model){
        List<Book> books = repo.findAll();
        model.addAttribute("books", books);
        return "index";
    }
}
