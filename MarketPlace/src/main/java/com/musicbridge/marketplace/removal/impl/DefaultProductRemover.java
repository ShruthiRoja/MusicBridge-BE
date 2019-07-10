package com.musicbridge.marketplace.removal.impl;

import com.musicbridge.marketplace.domain.Product;
import com.musicbridge.marketplace.loader.factory.ProductLoaderFactory;
import com.musicbridge.marketplace.removal.ProductRemover;
import com.musicbridge.marketplace.repository.CategoryRepository;
import com.musicbridge.marketplace.repository.ConditionRepository;
import com.musicbridge.marketplace.repository.ProductRepository;
import com.musicbridge.marketplace.repository.SubCategoryRepository;
import lombok.AllArgsConstructor;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
public class DefaultProductRemover implements ProductRemover {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final ConditionRepository conditionRepository;

    public void deleteProduct(UUID productId) {

        Product product = ProductLoaderFactory.getProductLoader(productRepository, categoryRepository,
                subCategoryRepository, conditionRepository).loadByProductId(productId);
        //Pre Removal
        productRepository.delete(product);
        //Post removal

    }

    public void deleteProducts(Set<UUID> productIds) {

    }
}
