package com.monkcommerce.couponservice.service.impl;

import com.monkcommerce.couponservice.dto.CartRequest;
import com.monkcommerce.couponservice.entity.Coupon;
import com.monkcommerce.couponservice.entity.ProductWiseCoupon;
import com.monkcommerce.couponservice.service.CouponService;

public class ProductWiseCouponService implements CouponService {

	@Override
	public boolean isApplicable(Coupon coupon, CartRequest cart) {
		ProductWiseCoupon c = (ProductWiseCoupon) coupon;
        return cart.getProductIds().contains(c.getProductId());
	}

	@Override
	public double calculateDiscount(Coupon coupon, CartRequest cart) {
		ProductWiseCoupon c = (ProductWiseCoupon) coupon;
        if (!isApplicable(c, cart)) {
        	return 0.0;
        }
        double discount = (c.getDiscountPercent() / 100) * cart.getTotalAmount();
        
        return discount;
	}

}
