package com.rivwoxx.books.service;

import com.rivwoxx.books.model.AllBooksResponse;import com.rivwoxx.books.model.BooksByIsbnRequest;import com.rivwoxx.books.model.BooksModel;

public interface BooksService {

    BooksModel getBooksByISBN(BooksByIsbnRequest request);

    AllBooksResponse getAllBooks();

    Void createNewBook(BooksModel request);
}
