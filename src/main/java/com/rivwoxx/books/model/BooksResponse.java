package com.rivwoxx.books.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BooksResponse {

    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private String readYear;
    private String pages;
    private String genre;
    private String mof;
}
