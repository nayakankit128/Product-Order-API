package com.order.Order.controller;


import com.order.Order.dto.OrderDTO;
import com.order.Order.exceptions.ProductNotFoundException;
import com.order.Order.services.OrderServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
public class OrderController {


    @Autowired
    private OrderServices orderService;

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }


    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderDTO orderDTO) {
        log.info("Received order request with orderId {}, and ProductId {} for Quantities {}", orderDTO.getId(), orderDTO.getProductId()
              , orderDTO.getQuantity());

            OrderDTO placedOrder = orderService.placeOrder(orderDTO);
            return ResponseEntity.ok(placedOrder);
    }
}