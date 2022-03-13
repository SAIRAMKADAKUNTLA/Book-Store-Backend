package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.LoginDto;
import com.bridgelabz.bookstore.dto.UserRequest;
import com.bridgelabz.bookstore.exception.BookStoreExceptions;
import com.bridgelabz.bookstore.model.UserModel;
import com.bridgelabz.bookstore.repository.UserRepo;
import com.bridgelabz.bookstore.utility.JwtToken;
import com.bridgelabz.bookstore.utility.MailUtility;
import com.bridgelabz.bookstore.utility.OtpGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private JwtToken jwtToken;

    @Autowired
    private MailUtility mailUtility;
    @Autowired
    private OtpGenerator otpGenerator;

    int emailotp;
    String jToken;

    @Override
    public String userLogin(LoginDto loginDto) {
        String userByEmail=userRepo.getEmail(loginDto.getEmail());
        String userByPassword=userRepo.getPassword(loginDto.getEmail());
        log.info(userByEmail);
        log.info(userByPassword);
        boolean username=loginDto.getEmail().equals(userByEmail);
        if(!username){
            return "Email is not valid";
        }
        boolean password=bCryptPasswordEncoder.matches(loginDto.getPassword(),userByPassword);
        log.info(userByPassword);
        log.info(loginDto.getPassword());
        if(!password){
            return "Invalid Password!!!";
        }
        jToken=jwtToken.createToken(userRepo.getId(loginDto.getEmail()));
        log.info("token is: "+jToken);
        String message="user logged in successfully and token is :"+jToken;
        return  message;
    }

    @Override
    public UserModel registerUser(UserRequest userRequest) throws MessagingException {
        UserModel user=new UserModel(userRequest);
        user.setPassword(bCryptPasswordEncoder.encode(userRequest.password));
        emailotp =otpGenerator.generateOTP();
        mailUtility.sendOtp(emailotp);
        return userRepo.save(user);
    }

    @Override
    public String verifyEmail(int otp) {
        if(otp == emailotp){
            return "YOUR EMAIL IS VERIFIED!!!";
        }
        else{
            return "YOUR EMAIL IS NOT VERIFIED!!!";
        }
    }

    @Override
    public String verifyUsingToken(String token) {
        if(token.equals(jToken)){
            return "user is verified by token";
        }
        else
        {
            return "user is not verified";
        }
    }

    @Override
    public List<UserModel> getAll() {
        return userRepo.findAll() ;
    }

    @Override
    public UserModel getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(()->new BookStoreExceptions("not found with "+id));
    }

    @Override
    public UserModel updateUserById(Long id, UserRequest userRequest) {
        UserModel userModel=this.getUserById(id);
        userModel.updateUser(userRequest);
        return userRepo.save(userModel) ;
    }

    @Override
    public void deleteUserById(Long id) {
        UserModel userModel=this.getUserById(id);
        userRepo.delete(userModel);
    }

    @Override
    public String forgotPassword(String emailId) throws MessagingException {
        String userByEmail=userRepo.getEmail(emailId);
        Long userId=userRepo.getId(emailId);
        boolean email=emailId.equals(userByEmail);
        if(!email){
            return "not found any user with this email id";
        }
        else{
            emailotp=otpGenerator.generateOTP();
            jToken=jwtToken.createToken(userId);
            mailUtility.sendOtpTo(emailotp,jToken,emailId);
            return "Otp send Successfully";
        }

    }

    @Override
    public String resetPassword(int otp, String newPassword) {
      boolean valid= otp == emailotp;
      if(!valid){
          return "incorrect otp entered";
      }
      else{
          UserModel userModel=new UserModel();
          userModel.setPassword(newPassword);
          userRepo.save(userModel);
          return "password changed ";
      }
    }


}
