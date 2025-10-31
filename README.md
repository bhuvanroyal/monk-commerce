# 🧾 Monk Commerce – Coupon Service

## 🏷️ Overview
This project is part of the **Monk Commerce Backend Assignment**, built to manage and apply different types of coupons in an e-commerce platform.  
It supports three main coupon types:
- **Cart-wise Coupon**  
- **Product-wise Coupon**  
- **BxGy Coupon (Buy X Get Y Free)**

  ## 🚀 API Endpoints

| Method | Endpoint | Description |
|--------|-----------|-------------|
| **POST** | `/coupons` | Create a new coupon (cart-wise, product-wise, or bxgy) |
| **GET** | `/coupons` | Retrieve all coupons |
| **GET** | `/coupons/{id}` | Retrieve a specific coupon |
| **PUT** | `/coupons/{id}` | Update an existing coupon |
| **DELETE** | `/coupons/{id}` | Delete a coupon |
| **POST** | `/applicable-coupons` | Get list of applicable coupons for a given cart |
| **POST** | `/apply-coupon/{id}` | Apply a coupon and return updated cart details |

## 🧩 Implemented Cases

### 🟢 1. Cart-wise Coupon
Applies a percentage discount to the **entire cart total** if it exceeds a specified threshold.

**Example:**
```json
{
  "type": "cart-wise",
  "details": {
    "threshold": 100,
    "discount": 10
  }
}

### 🟢2. Product-wise Coupon

Applies a discount on specific product(s) in the cart.

Example:

{
  "type": "product-wise",
  "details": {
    "product_id": 1,
    "discount": 20
  }
}




💡 If product #1 costs ₹100 × 3 → discount = ₹60.
