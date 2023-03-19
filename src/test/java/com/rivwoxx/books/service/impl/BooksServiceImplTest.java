package com.rivwoxx.books.service.impl;import com.rivwoxx.books.TestUtils;import com.rivwoxx.books.model.BooksByIsbnRequest;import com.rivwoxx.books.model.BooksDbResponse;import com.rivwoxx.books.model.BooksModel;import com.rivwoxx.books.respository.BooksRepository;import org.junit.jupiter.api.Assertions;import org.junit.jupiter.api.Test;import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class BooksServiceImplTest {

  @Mock
  BooksRepository repository;

  @InjectMocks
  BooksServiceImpl service;

  @Test
  void getBooksByISBN() {
    BooksDbResponse response = new BooksDbResponse();
    BooksByIsbnRequest request = new BooksByIsbnRequest();
    Mockito.when(repository.getBooksByISBN(Mockito.any())).thenReturn(response);
    Assertions.assertAll(()-> service.getBooksByISBN(request));
  }

  @Test
  void getExceptionBooksByISBN() {
    BooksDbResponse response = new BooksDbResponse();
    BooksByIsbnRequest request = new BooksByIsbnRequest();
    Assertions.assertThrows(ResponseStatusException.class, () -> service.getBooksByISBN(request));
  }


  @Test
  void getAllBooks() {
    List<BooksDbResponse> response = TestUtils.getAllBooks();
    Mockito.when(repository.findAll()).thenReturn(response);
    Assertions.assertAll(() ->service.getAllBooks());
    }


    @Test
    void createNewBook() {
    BooksModel request = new BooksModel();
    Assertions.assertAll(() -> service.createNewBook(request));

      }}