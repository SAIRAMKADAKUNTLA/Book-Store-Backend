package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.exception.BookStoreExceptions;
import com.bridgelabz.bookstore.model.BookModel;
import com.bridgelabz.bookstore.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;


    @Override
    public List<BookModel> getAllData() {
        return bookRepo.findAll();
    }

    @Override
    public BookModel addBook(BookDto bookDto) {
        BookModel bookModel=new BookModel(bookDto);
        return bookRepo.save(bookModel);
    }


    @Override
    public BookModel getData(Long id)  {
        return bookRepo.findById(id).orElseThrow(()-> new BookStoreExceptions("data not found"));
    }

    @Override
    public BookModel updateUser(Long id, BookDto bookDto)  {
        BookModel bookModel=this.getData(id);
        bookModel.updateBookData(bookDto);
        return bookRepo.save(bookModel);
    }
    @Override
    public void deleteData(Long id) {
        BookModel bookModel=this.getData(id);
        bookRepo.delete(bookModel);
    }



}
