package com.monkcommerce.couponservice.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartRequest {
	
	private List<CartItem> items;

    public double getTotalAmount() {
        if (items == null) return 0.0;
        return items.stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
    }
}
