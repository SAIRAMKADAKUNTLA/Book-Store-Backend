package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.OrderDto;
import com.bridgelabz.bookstore.exception.BookStoreExceptions;
import com.bridgelabz.bookstore.model.OrderModel;
import com.bridgelabz.bookstore.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepo orderRepo;
    @Override
    public void placeOrder(Long id) {
        

    }

    @Override
    public OrderModel addItemsOrder(OrderDto orderDto) {
        OrderModel orderModel=new OrderModel(orderDto);
        return orderRepo.save(orderModel);
    }

    @Override
    public OrderModel getOrder(Long id) {
        return orderRepo.findById(id).orElseThrow(()->new BookStoreExceptions("not found"));
    }
}
