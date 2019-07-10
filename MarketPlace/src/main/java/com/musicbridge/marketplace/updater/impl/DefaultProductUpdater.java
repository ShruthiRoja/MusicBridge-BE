package com.musicbridge.marketplace.updater.impl;

import com.musicbridge.marketplace.domain.Product;
import com.musicbridge.marketplace.dto.request.ProductUpdateRequest;
import com.musicbridge.marketplace.repository.CategoryRepository;
import com.musicbridge.marketplace.repository.ConditionRepository;
import com.musicbridge.marketplace.repository.ProductRepository;
import com.musicbridge.marketplace.repository.SubCategoryRepository;
import com.musicbridge.marketplace.updater.ProductUpdater;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class DefaultProductUpdater implements ProductUpdater {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final ConditionRepository conditionRepository;

    public Product updateProduct(Product product, ProductUpdateRequest productUpdateRequest) {

        product.setName(productUpdateRequest.getName());
        product.setCategoryId(productUpdateRequest.getCategoryId());
        product.setPrice(productUpdateRequest.getPrice());
        product.setBrand(productUpdateRequest.getBrand());
        product.setDescription(productUpdateRequest.getDescription());
        product.setSubCategoryId(productUpdateRequest.getSubCategoryId());
        product.setConditionId(productUpdateRequest.getConditionId());
        product.setImagesPath(productUpdateRequest.getVideosPath());
        return product;
    }
}
