package com.monkcommerce.couponservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatedCartItemResponse {

	private Long productId;
    private Integer quantity;
    private Double price;
    private Double totalDiscount;
}
