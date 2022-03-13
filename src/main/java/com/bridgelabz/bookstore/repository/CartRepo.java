package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.model.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<CartModel,Long> {

}
