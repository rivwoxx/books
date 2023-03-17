package com.rivwoxx.books.respository;

import com.rivwoxx.books.model.BooksDbResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<BooksDbResponse, String> {

  @Query(value = "SELECT * FROM books where isbn=?", nativeQuery = true)
  BooksDbResponse getBooksByISBN(String isbn);

}
