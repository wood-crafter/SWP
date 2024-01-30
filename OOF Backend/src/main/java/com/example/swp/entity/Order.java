package com.example.swp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "orders")
@SqlResultSetMapping(
        name = "OrderDto",
        classes = @ConstructorResult(
                targetClass = com.example.swp.dto.OrderDto.class,
                columns = {
                        @ColumnResult(name = "orderId", type = Float.class),
                        @ColumnResult(name = "status", type = Boolean.class),
                }
        )
)
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts;

}
