package com.bridgelabz.bookstore.model;

import com.bridgelabz.bookstore.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book_data")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long book_id;
    private  String author;
    private  String description;
    private  String logo;
    private  String name;
    private double price;
    private int quantity;

    public BookModel(BookDto bookDto){
        this.updateBookData(bookDto);
    }

    public void updateBookData(BookDto bookDto){
        this.author=bookDto.author;
        this.description=bookDto.description;
        this.logo=bookDto.logo;
        this.name=bookDto.name;
        this.price=bookDto.price;
        this.quantity=bookDto.quantity;
    }
}
