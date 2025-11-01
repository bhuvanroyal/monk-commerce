package com.monkcommerce.couponservice.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdatedCartResponse {

	private List<UpdatedCartItemResponse> items;
    private Double totalPrice;
    private Double totalDiscount;
    private Double finalPrice;
}
