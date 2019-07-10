package com.musicbridge.marketplace.updater;

import com.musicbridge.marketplace.domain.Product;
import com.musicbridge.marketplace.dto.request.ProductUpdateRequest;

public interface ProductUpdater {
    public Product updateProduct(Product product, ProductUpdateRequest productUpdateRequest);
}
