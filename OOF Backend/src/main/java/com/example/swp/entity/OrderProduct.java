package com.example.swp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_product")
@SqlResultSetMapping(
        name = "OrderProductDto",
        classes = @ConstructorResult(
                targetClass = com.example.swp.dto.OrderProductDto.class,
                columns = {
                        @ColumnResult(name = "productName", type = String.class),
                        @ColumnResult(name = "path", type = String.class),
                        @ColumnResult(name = "categoryName", type = String.class),
                        @ColumnResult(name = "supplierName", type = String.class),
                        @ColumnResult(name = "quantity", type = Integer.class),
                        @ColumnResult(name = "unitPrice", type = Float.class),
                }
        )
)
public class OrderProduct extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_size_id")
    private ProductStocktaking productStocktaking;

    @Column(name = "unit_price")
    private Float unitPrice;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
