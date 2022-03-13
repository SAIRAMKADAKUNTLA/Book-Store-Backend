package com.bridgelabz.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDto {
    public String order_date;
    public double price;
    public int quantity;
    public String address;
    public Long pincode;
    public Long user_id;
    public Long book_id;
}
