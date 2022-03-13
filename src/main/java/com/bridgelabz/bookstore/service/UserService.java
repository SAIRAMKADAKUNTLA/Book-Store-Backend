package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.LoginDto;
import com.bridgelabz.bookstore.dto.UserRequest;
import com.bridgelabz.bookstore.model.UserModel;

import javax.mail.MessagingException;
import java.util.List;

public interface UserService {
    String userLogin(LoginDto loginDto);

    UserModel registerUser(UserRequest userRequest) throws MessagingException;
    String verifyEmail(int otp) ;


    String verifyUsingToken(String token);

    List<UserModel> getAll();

    UserModel getUserById(Long id);

    UserModel updateUserById(Long id, UserRequest userRequest);


    void deleteUserById(Long id);

    String forgotPassword(String emailId) throws MessagingException;

    String resetPassword(int otp, String newPassword);
}
