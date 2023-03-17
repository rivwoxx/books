package com.rivwoxx.books.service;

import com.rivwoxx.books.model.AllBooksResponse;import com.rivwoxx.books.model.BooksByIsbnRequest;import com.rivwoxx.books.model.BooksResponse;import org.springframework.stereotype.Service;

public interface BooksService {

    BooksResponse getBooksByISBN(BooksByIsbnRequest request);

    AllBooksResponse getAllBooks();

    Void createNewBook(BooksResponse request);
}
