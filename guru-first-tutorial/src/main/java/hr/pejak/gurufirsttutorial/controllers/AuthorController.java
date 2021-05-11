package hr.pejak.gurufirsttutorial.controllers;

import hr.pejak.gurufirsttutorial.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hpejak via IntelliJ IDEA
 * 2021-05-03, 19:43
 */

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors",authorRepository.findAll());

        return "authors/list";
    }

}
