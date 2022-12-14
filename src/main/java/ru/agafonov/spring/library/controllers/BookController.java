package ru.agafonov.spring.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.agafonov.spring.library.dao.BookDAO;
import ru.agafonov.spring.library.dao.PersonDAO;
import ru.agafonov.spring.library.models.Book;
import ru.agafonov.spring.library.models.Person;

import javax.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDAO bookDAO;
    private final PersonDAO personDAO;

    @Autowired
    public BookController(BookDAO bookDAO, PersonDAO personDAO) {
        this.bookDAO = bookDAO;
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("books", bookDAO.index());

        return "book/index";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("books")Book book){
        return "book/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("books") @Valid Book book,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "book/new";

        bookDAO.save(book);

        return "redirect:/book";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("books", bookDAO.show(id));
        return "book/edit";
    }

    @GetMapping("/{id}")
    public String show(Model model, @ModelAttribute("person") Person person, @PathVariable("id") int id){
        model.addAttribute("books", bookDAO.show(id));
        model.addAttribute("booksAndPerson", bookDAO.bookAndPerson(id));
        model.addAttribute("people", personDAO.index());

        //model.addAttribute("bookIsTake", )
        return "book/show";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("books") @Valid Book book,
                         BindingResult bindingResult,
                         @PathVariable("id") int id){

        if(bindingResult.hasErrors())
            return "book/edit";

        bookDAO.update(id, book);
        return "redirect:/book";
    }

    @PatchMapping("/{id}/release")
    public String update(@PathVariable("id") int id){
        bookDAO.releaseBook(id);
        return "redirect:/book";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        bookDAO.delete(id);

        return "redirect:/book";
    }

    @PatchMapping("/{id}/assign")
    public String assign(@PathVariable("id") int id, @ModelAttribute("person")Person person){
        bookDAO.assign(id, person);
        return "redirect:/book/"+id;
    }
}
