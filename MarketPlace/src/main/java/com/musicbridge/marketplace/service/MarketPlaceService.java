package com.musicbridge.marketplace.service;

import com.musicbridge.marketplace.dto.request.ProductCreateRequest;
import com.musicbridge.marketplace.dto.request.ProductUpdateRequest;
import com.musicbridge.marketplace.dto.response.ProductInformation;

import java.util.UUID;

public interface MarketPlaceService {

    ProductInformation createProduct (ProductCreateRequest productCreateRequest);

    void deleteProduct(UUID productId );

    ProductInformation updateProduct ( UUID productId ,ProductUpdateRequest productUpdateRequest);

    ProductInformation getProduct( UUID productId);
}
