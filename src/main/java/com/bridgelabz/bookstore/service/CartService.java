package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartDto;
import com.bridgelabz.bookstore.model.CartModel;

import java.util.List;

public interface CartService {
    CartModel addToCart(CartDto cartDto);

    List<CartModel> getAll();

    CartModel getById(Long id);

    CartModel updateQty(Long id, Long quantity);

   void deleteById(Long id);
}
