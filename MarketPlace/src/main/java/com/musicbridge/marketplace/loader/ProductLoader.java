package com.musicbridge.marketplace.loader;

import com.musicbridge.marketplace.domain.Condition;
import com.musicbridge.marketplace.domain.Product;
import com.musicbridge.marketplace.domain.SubCategory;
import com.musicbridge.marketplace.dto.response.ProductInformation;

import java.util.UUID;

public interface ProductLoader {
    public ProductInformation convertToProductInformation(Product product,
                                                          SubCategory subCategory, Condition condition);

    public Product loadByProductId(UUID productId);
}
