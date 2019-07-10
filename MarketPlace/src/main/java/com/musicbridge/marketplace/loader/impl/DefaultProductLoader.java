package com.musicbridge.marketplace.loader.impl;

import com.musicbridge.marketplace.domain.Condition;
import com.musicbridge.marketplace.domain.Product;
import com.musicbridge.marketplace.domain.SubCategory;
import com.musicbridge.marketplace.dto.response.ProductInformation;
import com.musicbridge.marketplace.loader.ProductLoader;
import com.musicbridge.marketplace.repository.CategoryRepository;
import com.musicbridge.marketplace.repository.ConditionRepository;
import com.musicbridge.marketplace.repository.ProductRepository;
import com.musicbridge.marketplace.repository.SubCategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class DefaultProductLoader implements ProductLoader {

    protected final ProductRepository productRepository;
    protected final CategoryRepository categoryRepository;
    protected final SubCategoryRepository subCategoryRepository;
    protected final ConditionRepository conditionRepository;


    @Override
    public Product loadByProductId(UUID productId) {
        Product product = findByProductId(productId);
        if (product == null) {
            //throw exception;
        }
        return product;
    }

    public ProductInformation convertToProductInformation(Product product, SubCategory subCategory, Condition condition) {
        ProductInformation productInformation = new ProductInformation(product.getId(), product.getName(),
                product.getPrice(), product.getBrand(), product.getDescription(),
                subCategory, condition,
                product.getImagesPath(),
                product.getVideosPath(),
                product.getCreatedBy().get(),
                product.getCreatedDate().get());
        return productInformation;
    }

    protected Product findByProductId(UUID productId) {
        //get() can be also used as Optional value instead of null
        return getProductRepository().findById(productId).orElse(null);
    }
}
