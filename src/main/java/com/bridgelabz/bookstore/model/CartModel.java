package com.bridgelabz.bookstore.model;

import com.bridgelabz.bookstore.dto.CartDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart_data")
public class CartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long user_id;
    private Long book_id;
    private Long quantity;

    public CartModel(CartDto cartDto){
        this.updateCart(cartDto);
    }
    public void updateCart(CartDto cartDto){
        this.user_id=cartDto.user_id;
        this.book_id=cartDto.user_id;
        this.quantity=cartDto.quantity;
    }

}
