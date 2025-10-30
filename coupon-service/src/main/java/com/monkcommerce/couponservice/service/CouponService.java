package com.monkcommerce.couponservice.service;

import com.monkcommerce.couponservice.dto.CartRequest;
import com.monkcommerce.couponservice.entity.Coupon;

public interface CouponService {

	 boolean isApplicable(Coupon coupon, CartRequest cart);
	 double calculateDiscount(Coupon coupon, CartRequest cart);
}
