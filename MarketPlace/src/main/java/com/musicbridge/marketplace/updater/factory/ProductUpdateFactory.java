package com.musicbridge.marketplace.updater.factory;

import com.musicbridge.marketplace.repository.CategoryRepository;
import com.musicbridge.marketplace.repository.ConditionRepository;
import com.musicbridge.marketplace.repository.ProductRepository;
import com.musicbridge.marketplace.repository.SubCategoryRepository;
import com.musicbridge.marketplace.updater.ProductUpdater;
import com.musicbridge.marketplace.updater.impl.DefaultProductUpdater;

public class ProductUpdateFactory {

    public static ProductUpdater getProductUpdater(ProductRepository productRepository,
                                                   CategoryRepository categoryRepository,
                                                   SubCategoryRepository subCategoryRepository,
                                                   ConditionRepository conditionRepository){
        return new DefaultProductUpdater(productRepository,categoryRepository,subCategoryRepository,conditionRepository);
    }
}
