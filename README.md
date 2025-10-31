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

{
  "type": "cart-wise",
  "details": {
    "threshold": 100,
    "discount": 10
  }
} 

### 🟢 2. Product-wise Coupon

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

### 🟢 3. BxGy Coupon (Buy X Get Y Free)

Buy certain quantities of products from one list and get other products for free.

Example:

{
  "type": "bxgy",
  "details": {
    "buy_products": [
      {"product_id": 1, "quantity": 2},
      {"product_id": 2, "quantity": 2}
    ],
    "get_products": [
      {"product_id": 3, "quantity": 1}
    ],
    "repition_limit": 3
  }
}

💡 Buying 6 units of Product 1 → get 3 units of Product 3 free (worth ₹75).

Limitations

1. Product catalog data is not stored; pricing comes directly from cart request.
2. BxGy assumes same quantity rule for all buy-products.
3. No concurrency or transaction handling beyond basic persistence.
4. Single-table inheritance could become heavy if coupon types increase.
5. No API authentication or authorization layer included.
6. Currency assumed to be INR.
7. Basic error responses — no custom exception structure yet.

Assumptions

1. type field in requests is always valid (cart-wise, product-wise, bxgy).
2. Product IDs in cart are valid and unique.
3. All prices are in INR and positive numbers.
4. Each coupon can also have a unique code like SAVE10 or B2G1FREE.
5. Free items in BxGy are added to the same product’s quantity instead of separate items.
6. Future improvement: Introduce a data-driven rule engine allowing marketing teams to create new coupon types dynamically without code changes.
