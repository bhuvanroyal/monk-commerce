package com.monkcommerce.couponservice.entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "coupon_type")
@Data
@Entity
public abstract class Coupon {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String type;
	
//	@Column(nullable = false)
//	private String code;
//	
//	private boolean active;
//	
//	private LocalDate expiryDate;
//	
//	private String description;
//	
//	private LocalDate startDate;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	
	@PrePersist
	public void onCreate() {
	    this.createdAt = LocalDateTime.now();
	    this.updatedAt = LocalDateTime.now();
	}

	@PreUpdate
	public void onUpdate() {
	    this.updatedAt = LocalDateTime.now();
	}
}
