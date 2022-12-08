package ru.rsue.android;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookLab {
    private static BookLab sBookLab;
    private List<Book> mBooks;
    public static BookLab get(Context context) {
        if (sBookLab == null) {
            sBookLab = new BookLab(context);
        }
        return sBookLab;
    }
    private BookLab(Context context) {
        mBooks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Book book = new Book();
            book.setTitle("Book №" + i);
            book.setReaded(i % 2 == 0);
            mBooks.add(book);
        }
    }
    public List<Book> getBooks() {
        return mBooks;
    }
    public Book getBook(UUID id) {
        for (Book book : mBooks) {
            if(book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
}
