package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.CartDto;
import com.bridgelabz.bookstore.dto.UserRequest;
import com.bridgelabz.bookstore.dto.UserResponse;
import com.bridgelabz.bookstore.model.CartModel;
import com.bridgelabz.bookstore.model.UserModel;
import com.bridgelabz.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/addCart")
    public ResponseEntity<UserResponse> addCartData(@RequestBody CartDto cartDto)  {
        CartModel cartModel =cartService.addToCart(cartDto);
        UserResponse userResponse=new UserResponse("book added to cart Successfully!!!",cartModel);
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }
    @GetMapping("/getAllCartItems")
    public ResponseEntity<UserResponse>getAllCart(){
        List<CartModel> cartModel=cartService.getAll();
        UserResponse userResponse=new UserResponse("Total cart items : ",cartModel);
        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
    }
    @GetMapping("/getItem/{id}")
    public ResponseEntity<UserResponse>getAllCart(@PathVariable Long id){
        CartModel cartModel=cartService.getById(id);
        UserResponse userResponse=new UserResponse(" cart items : ","with "+id);
        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
    }
    @PutMapping("/updateQty")
    public ResponseEntity<UserResponse>updateQuantity(@RequestParam Long id,@RequestParam Long quantity){
        CartModel cartModel=cartService.updateQty(id,quantity);
        UserResponse userResponse=new UserResponse(" cart quantity updated : ",cartModel);
        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
    }
    @DeleteMapping("/deleteCart")
    public ResponseEntity<UserResponse>deleteFromCart(@RequestParam Long id){
        cartService.deleteById(id);
        UserResponse userResponse=new UserResponse("deleted successfully of id "+id,"!!!");
        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);

    }
}
