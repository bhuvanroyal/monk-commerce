package com.monkcommerce.couponservice.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("bxgy")
public class BxGyCoupon extends Coupon{

	@ElementCollection
    @Column(name = "buy_product_id")
    private List<Long> buyProductIds = new ArrayList<>();

    @ElementCollection
    @Column(name = "get_product_id")
    private List<Long> getProductIds = new ArrayList<>();

    private Integer buyQuantity;
    private Integer getQuantity;
    private Integer repetitionLimit;
}
