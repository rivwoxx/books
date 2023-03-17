package com.rivwoxx.books.controller;

import com.rivwoxx.books.model.AllBooksResponse;
import com.rivwoxx.books.model.BooksByIsbnRequest;
import com.rivwoxx.books.model.BooksResponse;
import com.rivwoxx.books.service.BooksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
@Validated
@Slf4j
public class BooksController {
  /** BookService. */
  BooksService service;

  /**
   * Controller for dependency injection.
   *
   * @param service BookService.
   */
  public BooksController(BooksService service) {
    this.service = service;
  }

  /**
   * Get book by ISBN Controller.
   *
   * @param request ISBN;
   * @return ResponseEntity.
   */
  @PostMapping("books/isbn")
  ResponseEntity<BooksResponse> getbooksByISBN(@RequestBody BooksByIsbnRequest request) {
    log.debug("ISBN in request: {}", request.getIsbn());
    BooksResponse response = service.getBooksByISBN(request);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  /**
   * Get all data inside Db controller.
   * @return ResponseEntity.
   */
  @GetMapping("books/all")
  ResponseEntity<AllBooksResponse> getAllBooks() {
    AllBooksResponse response = service.getAllBooks();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("books/new")
  ResponseEntity<Void> createNewBook(@RequestBody BooksResponse request){
    service.createNewBook(request);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

}
