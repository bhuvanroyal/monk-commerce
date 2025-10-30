package com.monkcommerce.couponservice.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {
	private List<Long> productIds;
    private Double totalAmount;
}
