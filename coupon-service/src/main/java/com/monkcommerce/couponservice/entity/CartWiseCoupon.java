package com.monkcommerce.couponservice.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("cart-wise")
public class CartWiseCoupon extends Coupon {
	
	private Double thresholdAmount;
	
	private Double discountPercent;

}
