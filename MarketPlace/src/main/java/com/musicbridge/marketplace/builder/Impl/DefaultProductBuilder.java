package com.musicbridge.marketplace.builder.Impl;

import com.musicbridge.marketplace.builder.ProductBuilder;
import com.musicbridge.marketplace.domain.Product;
import com.musicbridge.marketplace.dto.request.ProductCreateRequest;
import com.musicbridge.marketplace.repository.CategoryRepository;
import com.musicbridge.marketplace.repository.ConditionRepository;
import com.musicbridge.marketplace.repository.ProductRepository;
import com.musicbridge.marketplace.repository.SubCategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class DefaultProductBuilder implements ProductBuilder {

    protected final ProductRepository productRepository;
    protected final CategoryRepository categoryRepository;
    protected final SubCategoryRepository subCategoryRepository;
    protected final ConditionRepository conditionRepository;

    public Product buildProduct(ProductCreateRequest productCreateRequest) {
        Product product = new Product();
        product.setName(productCreateRequest.getName());
        product.setCategoryId(productCreateRequest.getCategoryId());
        product.setPrice(productCreateRequest.getPrice());
        product.setBrand(productCreateRequest.getBrand());
        product.setDescription(productCreateRequest.getDescription());
        product.setSubCategoryId(productCreateRequest.getSubCategoryId());
        product.setConditionId(productCreateRequest.getConditionId());
        product.setImagesPath(productCreateRequest.getImagesPath());
        product.setVideosPath(productCreateRequest.getVideosPath());
        product = productRepository.saveAndFlush(product);
        return product;
    }
}
