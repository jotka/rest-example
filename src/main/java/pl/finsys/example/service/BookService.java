package pl.finsys.example.service;

import pl.finsys.example.domain.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);

    List<Book> getList();

    Book getBook(String bookid);
}
