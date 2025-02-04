package com.order.Order.services;


import ch.qos.logback.core.util.StringUtil;
import com.order.Order.dto.OrderDTO;
import com.order.Order.dto.ProductResponse;
import com.order.Order.exceptions.ProductNotFoundException;
import com.order.Order.model.Order;
import com.order.Order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServices {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String productUrl = "http://localhost:8080/product/";

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO getOrderById(String id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Order not found"));
        return convertToDTO(order);
    }

    public OrderDTO placeOrder(OrderDTO orderDTO) {

        log.info("placing order with product id {}", orderDTO.getProductId());

        try {
            ProductResponse productResponse=restTemplate.getForObject(productUrl + orderDTO.getProductId(), ProductResponse.class);
            if (ObjectUtils.isEmpty(productResponse)) {
                log.info("Product is not found");
                throw new ProductNotFoundException("product not found");
            }
            else {
                Order order = convertToEntity(orderDTO);
                order.setStatus("PLACED");
                order.setTotalPrice(orderDTO.getQuantity() * productResponse.getPrice());
                Order savedOrder = orderRepository.save(order);
                log.info("Order placced successfully {}",orderDTO);
                return convertToDTO(savedOrder);
            }
        } catch (Exception e) {
            log.error("Error Occured {}", e.getMessage());
            throw new ProductNotFoundException(e.getMessage());
        }

    }

    private Order convertToEntity(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setProductId(dto.getProductId());
        order.setQuantity(dto.getQuantity());
        order.setStatus(dto.getStatus());
        return order;
    }

    private OrderDTO convertToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setProductId(order.getProductId());
        dto.setQuantity(order.getQuantity());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setStatus(order.getStatus());
        return dto;
    }


}
