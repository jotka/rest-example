package pl.finsys.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import pl.finsys.example.domain.Book;
import pl.finsys.example.service.BookService;
import pl.finsys.example.service.exception.BookAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;

    @Autowired
    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public Book saveBook(@RequestBody @Valid final Book book) {
        LOGGER.debug("Received request to create the {}", book);
        return bookService.saveBook(book);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> listBooks() {
        LOGGER.debug("Received request to list all users");
        return bookService.getList();
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public Book listBooks(@PathVariable Long bookid) {
        LOGGER.debug("Received request to list a specific book");
        return bookService.getBook(bookid);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable Long bookid) {
        LOGGER.debug("Received request to delete a specific book");
        bookService.deleteBook(bookid);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserAlreadyExistsException(BookAlreadyExistsException e) {
        return e.getMessage();
    }

}
