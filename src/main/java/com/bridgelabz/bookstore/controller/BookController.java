package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.dto.UserResponse;
import com.bridgelabz.bookstore.model.BookModel;
import com.bridgelabz.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore")
public class BookController {

    @Autowired
   private BookService service;

    @GetMapping("/getall")
    public ResponseEntity<UserResponse>getAllUserData(){
        List<BookModel> user=service.getAllData();
        UserResponse userResponse=new UserResponse("get all book  data ",user);
        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
    }
    @PostMapping("/addBook")
    public ResponseEntity<UserResponse>addBook(@RequestBody BookDto bookDto){
        BookModel bookModel=service.addBook(bookDto);
        UserResponse userResponse=new UserResponse("book Added Successfully",bookModel);
        return  new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<UserResponse>updateUserData(@PathVariable Long id, @RequestBody BookDto bookDto){
        BookModel bookModel=service.updateUser(id,bookDto);
        UserResponse userResponse=new UserResponse("Book Updated Successfully!!!",bookModel);
        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponse>getUserData(@PathVariable Long id){
        BookModel bookModel=service.getData(id);
        UserResponse userResponse=new UserResponse("get  data of id::"+id,bookModel);
        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponse>deleteUserData(@PathVariable Long id){
        service.deleteData(id);
        UserResponse userResponse=new UserResponse("deleted Successfully","deleted id is : "+id);
        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
    }


}
