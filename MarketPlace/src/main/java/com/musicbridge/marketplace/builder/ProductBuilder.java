package com.musicbridge.marketplace.builder;

import com.musicbridge.marketplace.domain.Product;
import com.musicbridge.marketplace.dto.request.ProductCreateRequest;

public interface ProductBuilder {

    Product buildProduct (ProductCreateRequest productCreateRequest);
}
