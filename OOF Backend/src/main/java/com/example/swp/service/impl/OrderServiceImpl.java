package com.example.swp.service.impl;

import com.example.swp.common.OrderStatusEnum;
import com.example.swp.custom_repository.OrderCustomRepository;
import com.example.swp.custom_repository.OrderProductCustomRepository;
import com.example.swp.dto.OrderDto;
import com.example.swp.dto.OrderWithOrderProductDto;
import com.example.swp.entity.*;
import com.example.swp.repository.CartRepository;
import com.example.swp.repository.OrderRepository;
import com.example.swp.service.CartService;
import com.example.swp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderCustomRepository orderCustomRepo;

    @Autowired
    private OrderProductCustomRepository orderProductCustomRepo;

    @Override
    @Transactional
    public Order createOrder(User user, List<Float> cartIds) {
        if (CollectionUtils.isEmpty(cartIds)) {
            throw new RuntimeException("There is no product!");
        }
        // Create order
        Order order = new Order();
        order.setUser(user);
        order.setStatus(OrderStatusEnum.DELIVERING.getId());
        order.setOrderProducts(new ArrayList<>());
        List<Cart> carts = cartRepo.findAllById(cartIds);

        // Create Order product
        carts.stream().forEach(x -> {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setProductStocktaking(new ProductStocktaking());
            orderProduct.setProductStocktaking(x.getProductStocktaking());
            orderProduct.setQuantity(x.getQuantity());
            orderProduct.setOrder(order);
            orderProduct.getProductStocktaking().getProduct().setComments(null);
            orderProduct.setUnitPrice(x.getProductStocktaking().getProduct().getPrice());
            order.getOrderProducts().add(orderProduct);
        });

        cartService.delete(cartIds);
        return orderRepo.save(order);
    }

    @Override
    public List<OrderWithOrderProductDto> findAll(User user) {
        List<OrderDto> orders = orderCustomRepo.findByUserId(user.getId());
        List<OrderWithOrderProductDto> orderWithOrderProducts = new ArrayList<>();
        for (OrderDto order : orders) {
            OrderWithOrderProductDto orderWithOrderProductDto = new OrderWithOrderProductDto();
            orderWithOrderProductDto.setOrder(order);
            orderWithOrderProductDto.setOrderProducts(orderProductCustomRepo.findByOrderId(order.getOrderId()));
            orderWithOrderProducts.add(orderWithOrderProductDto);
        }
        return orderWithOrderProducts;
//        return orderRepo.findAllByUserOrderByStatusAscCreatedDateDesc(user).stream().map(x -> {
//            x.setUser(null);
//            x.getOrderProducts().stream().map(o -> {
//                o.setOrder(null);
//                o.getProductSize().getProduct().setProductSizes(null);
//                o.getProductSize().getProduct().setComments(null);
////                o.getProductSize().getProduct().getCategory().setProducts(null);
////                o.getProductSize().getProduct().getSupplier().setProducts(null);
////                o.getProductSize().setCarts(null);
//                return o;
//            }).toList();
//            return x;
//        }).toList();
    }

    @Override
    public Order findById(Float id) {
        Order order = orderRepo.findById(id).get();
        order.setUser(null);
//        order.getOrderProducts().stream().map(o -> {
//            o.setOrder(null);
//            o.getProductSize().getProduct().setProductSizes(null);
//            o.getProductSize().getProduct().getCategory().setProducts(null);
//            o.getProductSize().getProduct().getSupplier().setProducts(null);
//            o.getProductSize().setCarts(null);
//            return o;
//        }).toList();
        return order;
    }
}
