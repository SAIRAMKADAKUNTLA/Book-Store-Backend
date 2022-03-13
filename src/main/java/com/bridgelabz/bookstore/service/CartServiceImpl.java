package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartDto;
import com.bridgelabz.bookstore.exception.BookStoreExceptions;
import com.bridgelabz.bookstore.model.CartModel;
import com.bridgelabz.bookstore.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
   private CartRepo cartRepo;
    @Override
    public CartModel addToCart(CartDto cartDto) {
        CartModel cartModel=new CartModel(cartDto);
        return cartRepo.save(cartModel);
    }

    @Override
    public List<CartModel> getAll() {
        return cartRepo.findAll();
    }

    @Override
    public CartModel getById(Long id) {
        return cartRepo.findById(id).orElseThrow(()->new BookStoreExceptions("not found"));
    }

    @Override
    public CartModel updateQty(Long id, Long quantity) {
        CartModel cartModel=this.getById(id);
        cartModel.setQuantity(quantity);
        return cartRepo.save(cartModel);
    }

    @Override
    public void deleteById(Long id) {
        CartModel cartModel=this.getById(id);
        cartRepo.delete(cartModel);
    }

}
