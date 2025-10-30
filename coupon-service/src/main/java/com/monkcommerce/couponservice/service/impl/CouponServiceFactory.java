package com.monkcommerce.couponservice.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.monkcommerce.couponservice.entity.Coupon;
import com.monkcommerce.couponservice.service.CouponService;

@Component
public class CouponServiceFactory {

	private final Map<String, CouponService> services;

    @Autowired
    public CouponServiceFactory(Map<String, CouponService> services) {
        this.services = services;
    }

    public CouponService getService(Coupon coupon) {
        switch (coupon.getType()) {
            case "cart-wise":
                return services.get("cartWiseCouponService");
            case "product-wise":
                return services.get("productWiseCouponService");
            case "bxgy":
                return services.get("bxgyCouponService");
            default:
                throw new IllegalArgumentException("Unknown coupon type: " + coupon.getType());
        }
    }
}
