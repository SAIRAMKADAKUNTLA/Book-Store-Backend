package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.dto.UserRequest;
import com.bridgelabz.bookstore.model.BookModel;
import com.bridgelabz.bookstore.model.UserModel;

import java.util.List;

public interface BookService {

    List<BookModel> getAllData();

    BookModel addBook(BookDto bookDto);

    BookModel updateUser(Long id, BookDto bookDto);

    BookModel getData(Long id);

    void deleteData(Long id);
}
