package edu.icet.ecom.dto;

import edu.icet.ecom.util.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Product {
    private Integer id;
    private ProductCategory category;
    private String name;
    private Double price;
    private String image;

}
