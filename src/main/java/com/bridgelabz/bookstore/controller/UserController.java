package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.LoginDto;
import com.bridgelabz.bookstore.dto.UserRequest;
import com.bridgelabz.bookstore.dto.UserResponse;
import com.bridgelabz.bookstore.model.UserModel;
import com.bridgelabz.bookstore.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<UserResponse>addUserData(@RequestBody UserRequest userRequest) throws MessagingException {
        UserModel userModel=service.registerUser(userRequest);
        UserResponse userResponse=new UserResponse("User Registered Successfully!!!",userModel);
        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
    }
    @GetMapping("/getUsers")
    public ResponseEntity<UserResponse>getAllUsers(){
        List<UserModel> userModel=service.getAll();
        UserResponse userResponse=new UserResponse("Total users : ",userModel);
        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
    }
    @GetMapping("/getUsers/{id}")
    public ResponseEntity<UserResponse>getAllUsers(@PathVariable Long id){
        UserModel userModel=service.getUserById(id);
        UserResponse userResponse=new UserResponse("User with id  "+id+" is ",userModel);
        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
    }
    @PutMapping("/editUser/{id}")
    public ResponseEntity<UserResponse>editUser(@PathVariable Long id ,@RequestBody UserRequest userRequest){
        UserModel userModel=service.updateUserById(id,userRequest);
        UserResponse userResponse=new UserResponse("User Updated for id  "+id+" is ",userModel);
        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<UserResponse>deleteUser(@PathVariable Long id){
         service.deleteUserById(id);
        UserResponse userResponse=new UserResponse("User deleted for id  "+id,"is");
        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String user=service.userLogin(loginDto);
        return  new ResponseEntity<String>(user, HttpStatus.OK);
    }
    @PostMapping("/verifyEmail")
    public ResponseEntity<String> verifyUser(@RequestParam int otp) {
        return  new ResponseEntity<String>(service.verifyEmail(otp),HttpStatus.OK);
    }

    @PostMapping("/verifyByToken")
    public ResponseEntity<String> verifyByToken(@RequestParam String token){
        return new ResponseEntity<String>(service.verifyUsingToken(token),HttpStatus.OK);
    }
    @PostMapping("/forgotPassword")
    public ResponseEntity<String> forgotPwd(@RequestParam String emailId) throws MessagingException {
        return new ResponseEntity<String>(service.forgotPassword(emailId),HttpStatus.OK);
    }
    @PutMapping("/resetPassword")
    public ResponseEntity<String> resetPwd(@RequestParam int otp,@RequestParam String newPassword) throws MessagingException {
        return new ResponseEntity<String>(service.resetPassword(otp,newPassword),HttpStatus.OK);
    }

}
