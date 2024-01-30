package com.example.swp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "products")
@SqlResultSetMapping(
        name = "ProductDto",
        classes = @ConstructorResult(
                targetClass = com.example.swp.dto.ProductDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "productName", type = String.class),
                        @ColumnResult(name = "imagePath", type = String.class),
                        @ColumnResult(name = "price", type = Float.class),
                        @ColumnResult(name = "status", type = String.class),
                        @ColumnResult(name = "description", type = String.class),
                        @ColumnResult(name = "categoryName", type = String.class),
                        @ColumnResult(name = "supplierName", type = String.class)
                }
        )
)
public class Product extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Float price;

    @Column(name = "path")
    private String path;

    @Column(name = "description", length = 999)
    private String description;

    @Column(name = "status")
    private Double status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductStocktaking> productStocktaking;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Comment> comments;

}
