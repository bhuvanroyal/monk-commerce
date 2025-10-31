package com.monkcommerce.couponservice.service.impl;

import org.springframework.stereotype.Service;

import com.monkcommerce.couponservice.dto.CartItem;
import com.monkcommerce.couponservice.dto.CartRequest;
import com.monkcommerce.couponservice.entity.Coupon;
import com.monkcommerce.couponservice.entity.ProductWiseCoupon;
import com.monkcommerce.couponservice.service.CouponService;

@Service("productWiseCouponService")
public class ProductWiseCouponService implements CouponService {

	 	@Override
	    public boolean isApplicable(Coupon coupon, CartRequest cart) {
	        ProductWiseCoupon c = (ProductWiseCoupon) coupon;

	        return cart.getItems().stream()
	                .anyMatch(item -> item.getProductId().equals(c.getProductId()));
	    }

	    @Override
	    public double calculateDiscount(Coupon coupon, CartRequest cart) {
	        ProductWiseCoupon c = (ProductWiseCoupon) coupon;

	        if (!isApplicable(c, cart)) {
	            return 0.0;
	        }

	        double totalDiscount = 0.0;
	        for (CartItem item : cart.getItems()) {
	            if (item.getProductId().equals(c.getProductId())) {
	                double productTotal = item.getPrice() * item.getQuantity();
	                totalDiscount = (c.getDiscountPercent() / 100.0) * productTotal;
	                break;
	            }
	        }

	        return totalDiscount;
	    }

}
