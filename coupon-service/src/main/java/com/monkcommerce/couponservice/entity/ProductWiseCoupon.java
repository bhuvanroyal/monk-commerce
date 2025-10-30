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
@DiscriminatorValue("product-wise")
public class ProductWiseCoupon extends Coupon {

	 private Long productId;

	 private Double discountPercent; 
	
}
