package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Item {
    private Integer code;
    private String name;
    private Double price;
    private String image;
    private String category;

}
