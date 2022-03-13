package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.OrderDto;
import com.bridgelabz.bookstore.model.OrderModel;

public interface OrderService {
    void placeOrder(Long id);

    OrderModel addItemsOrder(OrderDto orderDto);

    OrderModel getOrder(Long id);
}
