package com.musicbridge.marketplace.removal.factory;

import com.musicbridge.marketplace.removal.ProductRemover;
import com.musicbridge.marketplace.removal.impl.DefaultProductRemover;
import com.musicbridge.marketplace.repository.CategoryRepository;
import com.musicbridge.marketplace.repository.ConditionRepository;
import com.musicbridge.marketplace.repository.ProductRepository;
import com.musicbridge.marketplace.repository.SubCategoryRepository;

public class ProductRemoverFactory {

    public static ProductRemover getProductRemover(ProductRepository productRepository,
                                                   CategoryRepository categoryRepository,
                                                   SubCategoryRepository subCategoryRepository,
                                                   ConditionRepository conditionRepository) {
        return new DefaultProductRemover(productRepository, categoryRepository, subCategoryRepository, conditionRepository);
    }
}
