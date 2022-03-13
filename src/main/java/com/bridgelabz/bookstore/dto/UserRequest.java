package com.bridgelabz.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {
    public String first_name;
    public String last_name;
    public String kyc;
    public String dob;
    public String registered_date;
    public String updated_date;
    public String email;
    public String password;
    public boolean verify;
    public String purchase_date;
    public String expiry_date;
}
