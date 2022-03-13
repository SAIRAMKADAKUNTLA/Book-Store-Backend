package com.bridgelabz.bookstore.model;

import com.bridgelabz.bookstore.dto.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user_data")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long user_id;
    private String first_name;
    private String last_name;
    private String kyc;
    private String dob;
    private String registered_date;
    private String updated_date;
    private String email;
    private String password;
    private boolean verify;
    private String purchase_date;
    private String expiry_date;

    public UserModel(UserRequest userRequest){
        this.updateUser(userRequest);
    }

    public void updateUser(UserRequest  userRequest){
        this.first_name=userRequest.first_name;
        this.last_name=userRequest.last_name;
        this.kyc= userRequest.kyc;
        this.dob=userRequest.dob;
        this.registered_date=userRequest.registered_date;
        this.updated_date=userRequest.updated_date;
        this.email=userRequest.email;
        this.password=userRequest.password;
        this.verify=userRequest.verify;
        this.purchase_date=userRequest.purchase_date;
        this.expiry_date=userRequest.expiry_date;

    }
}
