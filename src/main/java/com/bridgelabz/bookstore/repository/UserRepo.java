package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Long> {
    @Query(value = "select email from user_data where email=:email",nativeQuery = true)
    String getEmail(String email);
    @Query(value = "select password from user_data where email=:email",nativeQuery = true)
    String getPassword(String email);
    @Query(value = "select user_id from user_data where email=:email",nativeQuery = true)
    Long getId(String email);
}
