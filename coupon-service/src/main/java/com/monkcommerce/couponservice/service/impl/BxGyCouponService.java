package com.monkcommerce.couponservice.service.impl;

import org.springframework.stereotype.Service;

import com.monkcommerce.couponservice.dto.CartItem;
import com.monkcommerce.couponservice.dto.CartRequest;
import com.monkcommerce.couponservice.entity.BxGyCoupon;
import com.monkcommerce.couponservice.entity.Coupon;
import com.monkcommerce.couponservice.service.CouponService;

@Service("bxgyCouponService")
public class BxGyCouponService implements CouponService {

	 @Override
	    public boolean isApplicable(Coupon coupon, CartRequest cart) {
	        BxGyCoupon c = (BxGyCoupon) coupon;

	        for (CartItem item : cart.getItems()) {
	            Integer requiredQty = c.getBuyProducts().get(item.getProductId());
	            if (requiredQty != null && item.getQuantity() >= requiredQty) {
	                return true;
	            }
	        }

	        return false;
	    }

	    @Override
	    public double calculateDiscount(Coupon coupon, CartRequest cart) {
	        BxGyCoupon c = (BxGyCoupon) coupon;

	        double totalDiscount = 0.0;

	        int totalRepetitions = 0;

	        for (CartItem item : cart.getItems()) {
	            Integer requiredQty = c.getBuyProducts().get(item.getProductId());
	            if (requiredQty != null && requiredQty > 0) {
	                int reps = item.getQuantity() / requiredQty;
	                totalRepetitions += reps;
	            }
	        }
	        totalRepetitions = Math.min(totalRepetitions, c.getRepetitionLimit());

	        for (CartItem item : cart.getItems()) {
	            if (c.getGetProducts().containsKey(item.getProductId())) {
	                int freeQty = c.getGetProducts().get(item.getProductId()) * totalRepetitions;
	                double itemDiscount = freeQty * item.getPrice();
	                totalDiscount += itemDiscount;
	            }
	        }

	        return totalDiscount;
	    }

}
