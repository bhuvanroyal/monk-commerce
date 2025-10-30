package com.monkcommerce.couponservice.service.impl;

import com.monkcommerce.couponservice.dto.CartRequest;
import com.monkcommerce.couponservice.entity.BxGyCoupon;
import com.monkcommerce.couponservice.entity.Coupon;
import com.monkcommerce.couponservice.service.CouponService;

public class BxGyCouponService implements CouponService {

	@Override
	public boolean isApplicable(Coupon coupon, CartRequest cart) {
		BxGyCoupon c = (BxGyCoupon) coupon;

        long buyCount = cart.getProductIds().stream()
                .filter(p -> c.getBuyProductIds().contains(p))
                .count();

        return buyCount >= c.getBuyQuantity();
	}

	@Override
	public double calculateDiscount(Coupon coupon, CartRequest cart) {
		BxGyCoupon c = (BxGyCoupon) coupon;

        long buyCount = cart.getProductIds().stream()
                .filter(p -> c.getBuyProductIds().contains(p))
                .count();

        long getCount = cart.getProductIds().stream()
                .filter(p -> c.getGetProductIds().contains(p))
                .count();

      
        int applicableRepetitions = (int) Math.min(
                buyCount / c.getBuyQuantity(),
                c.getRepetitionLimit()
        );

        int freeItems = applicableRepetitions * c.getGetQuantity();

        return freeItems;
	}

}
