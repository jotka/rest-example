package pl.finsys.example.util;

import pl.finsys.example.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class UserUtil {

    private static final String ID = "id";
    private static final String PASSWORD = "password";

    private UserUtil() {
    }

    public static Book createUser() {
        return new Book(ID, PASSWORD);
    }

    public static List<Book> createUserList(int howMany) {
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            bookList.add(new Book(ID + "#" + i, PASSWORD));
        }
        return bookList;
    }

}
