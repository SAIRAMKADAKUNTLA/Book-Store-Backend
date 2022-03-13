package com.bridgelabz.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDto {
    public String author;
    public   String description;
    public   String logo;
    public   String name;
    public double price;
    public int quantity;
}
