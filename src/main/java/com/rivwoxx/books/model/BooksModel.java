package com.rivwoxx.books.model;

import lombok.Getter;
import lombok.Setter;import javax.validation.constraints.NotEmpty;import javax.validation.constraints.NotNull;import javax.validation.constraints.Size;

@Setter
@Getter
public class BooksModel {

    private String title;
    private String author;
    private String publisher;
    @NotNull
    @NotEmpty
    @Size(min = 10,  max = 13, message = "ISBN VALUE MUST BE 10 OR 13 CHARACTERS.")
    private String isbn;
    private String readYear;
    private String pages;
    private String genre;
    private String mof;
}
