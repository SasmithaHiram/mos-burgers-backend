package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Order {
    private Integer id;
    private Double totalAmount;
    private String customerName;
    private List<OrderDetail> orderDetails;

}
