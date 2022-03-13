package com.bridgelabz.bookstore.model;

import com.bridgelabz.bookstore.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_data")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String order_date;
    private double price;
    private int quantity;
    private String address;
    private Long pincode;
    private Long user_id;
    private Long book_id;

    public OrderModel(OrderDto orderDto){
        this.updateOrder(orderDto);
    }
    public void updateOrder(OrderDto orderDto){
        this.order_date=orderDto.order_date;
        this.price=orderDto.price;
        this.quantity=orderDto.quantity;
        this.address=orderDto.address;
        this.pincode=orderDto.pincode;
        this.user_id=orderDto.user_id;
        this.book_id=orderDto.book_id;
    }
}
