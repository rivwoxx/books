package com.rivwoxx.books.model;

import lombok.Getter;
import lombok.Setter;import java.util.List;

@Setter
@Getter
public class AllBooksDbResponse {

    private List<BooksDbResponse> listAllBooks;
}
