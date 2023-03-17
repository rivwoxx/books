package com.rivwoxx.books;

import com.rivwoxx.books.model.BooksDbResponse;import java.util.ArrayList;import java.util.List;public class TestUtils {

    public static BooksDbResponse getBooksDbResponse(){
        BooksDbResponse response = new BooksDbResponse();
        response.setId(1);
        response.setTitle("Anna Karenina");
        response.setAuthor("Leon Tolstoy");
        response.setPublisher("N/A");
        response.setIsbn("ISBNGENERIC");
        response.setYearr("2020");
        response.setMof("M");
        response.setGenre("Historic");
        response.setPages("420");
        return response;
    }

    public static List<BooksDbResponse> getAllBooks(){
        List<BooksDbResponse> allBooks = new ArrayList<>();
        BooksDbResponse book = getBooksDbResponse();
        allBooks.add(book);
        return allBooks;
    }

}
