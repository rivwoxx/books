package com.rivwoxx.books.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
public class BooksByIsbnRequest {

  private String isbn;
}
