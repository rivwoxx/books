package com.rivwoxx.books.controller;

import com.rivwoxx.books.model.AllBooksResponse;import com.rivwoxx.books.model.BooksByIsbnRequest;import com.rivwoxx.books.model.BooksModel;import com.rivwoxx.books.service.BooksService;import org.junit.jupiter.api.Assertions;import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;import org.mockito.Mock;import org.mockito.Mockito;import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BooksControllerTest {

  @Mock
  BooksService service;

  @InjectMocks
  BooksController controller;


  @Test
  void getbooksByISBNTest() {
    BooksByIsbnRequest request = new BooksByIsbnRequest();
    request.setIsbn("978-3-16-148410-0");
    Mockito.when(service.getBooksByISBN(Mockito.any())).thenReturn(null);
    Assertions.assertAll(() -> controller.getbooksByISBN(request));

  }

  @Test
  void getAllBooksTest() {
    AllBooksResponse response = new AllBooksResponse();
    Mockito.when(service.getAllBooks()).thenReturn(response);
    Assertions.assertAll(()->controller.getAllBooks());
  }

  @Test
  void createNewBookTest() {
    BooksModel request = new BooksModel();
    Assertions.assertAll(() -> controller.createNewBook(request));
  }
}
