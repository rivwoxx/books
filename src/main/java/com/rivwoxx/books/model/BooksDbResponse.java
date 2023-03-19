package com.rivwoxx.books.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
// import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "books")
public class BooksDbResponse {

  @Id
  @Column(name = "Id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "title")
  private String title;
  @Column(name = "author")
  private String author;
  @Column(name = "publisher")
  private String publisher;
  @Column(name = "isbn")
  private String isbn;
  @Column(name = "yearr")
  private String yearr;
  @Column(name = "pages")
  private String pages;
  @Column(name = "genre")
  private String genre;
  @Column(name = "mof")
  private String mof;
}
