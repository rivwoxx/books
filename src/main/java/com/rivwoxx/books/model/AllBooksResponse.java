package com.rivwoxx.books.model;


import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class AllBooksResponse {

  private List<BooksModel> books;
}
