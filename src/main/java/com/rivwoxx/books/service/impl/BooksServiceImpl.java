package com.rivwoxx.books.service.impl;

import com.rivwoxx.books.model.*;
import com.rivwoxx.books.respository.BooksRepository;
import com.rivwoxx.books.service.BooksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Objects;import java.util.stream.Collectors;

@Service
@Slf4j
public class BooksServiceImpl implements BooksService {
  BooksRepository repository;

  /**
   * Constructor for dependency injection.
   *
   * @param repository BookRepository.
   */
  public BooksServiceImpl(BooksRepository repository) {
    this.repository = repository;
  }

  /**
   * GetBooksByISBN
   *
   * @param request ISBN.
   * @return BooksDbResponse.
   */
  @Override
  public BooksModel getBooksByISBN(BooksByIsbnRequest request) {
    BooksDbResponse dbResponse = repository.getBooksByISBN(request.getIsbn());
    notNullValidation(dbResponse);
    return setBooksResponse(dbResponse);
  }

  /**
   * Get All Data in DB.
   *
   * @return response AllBooksResponse.
   */
  @Override
  public AllBooksResponse getAllBooks() {
    log.info("Getting all the books in DB");
    List<BooksDbResponse> dbResponseList = repository.findAll();

    List<BooksModel> booksResponses =
        dbResponseList.stream()
            .limit(dbResponseList.size())
            .map(this::setBooksResponse)
            .collect(Collectors.toList());

    AllBooksResponse response = new AllBooksResponse();
    response.setBooks(booksResponses);
    return response;
  }

  @Override
  public Void createNewBook(BooksModel request) {
    BooksDbResponse dbRequest = new BooksDbResponse();
    dbRequest.setTitle(request.getTitle());
    dbRequest.setAuthor(request.getAuthor());
    dbRequest.setPublisher(request.getPublisher());
    dbRequest.setIsbn(request.getIsbn());
    dbRequest.setYearr(request.getReadYear());
    dbRequest.setMof(request.getMof());
    dbRequest.setGenre(request.getGenre());
    dbRequest.setPages(request.getPages());
    repository.save(dbRequest);
    return null;
  }

  /**
   * Set correct Response from DB.
   *
   * @param dbResponse DBResponse.
   * @return BooksResponse.
   */
  private BooksModel setBooksResponse(BooksDbResponse dbResponse) {
    BooksModel response = new BooksModel();

    response.setTitle(dbResponse.getTitle());
    response.setAuthor(dbResponse.getAuthor());
    response.setPublisher(dbResponse.getPublisher());
    response.setIsbn(dbResponse.getIsbn());
    response.setReadYear(dbResponse.getYearr());
    response.setMof(dbResponse.getMof());
    response.setGenre(dbResponse.getGenre());
    response.setPages(dbResponse.getPages());
    return response;
  }

  private BooksDbResponse notNullValidation(BooksDbResponse obj){
    if(Objects.isNull(obj)){
      throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "SQL error");
    }
    return obj;
  }
}
