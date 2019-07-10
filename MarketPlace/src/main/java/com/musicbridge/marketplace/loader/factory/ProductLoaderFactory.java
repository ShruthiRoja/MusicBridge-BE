package com.musicbridge.marketplace.loader.factory;

import com.musicbridge.marketplace.loader.ProductLoader;
import com.musicbridge.marketplace.loader.impl.DefaultProductLoader;
import com.musicbridge.marketplace.repository.CategoryRepository;
import com.musicbridge.marketplace.repository.ConditionRepository;
import com.musicbridge.marketplace.repository.ProductRepository;
import com.musicbridge.marketplace.repository.SubCategoryRepository;

public class ProductLoaderFactory {

    public static ProductLoader getProductLoader (ProductRepository productRepository ,
                                    CategoryRepository categoryRepository,
                                    SubCategoryRepository subCategoryRepository,
                                    ConditionRepository conditionRepository)
    {
        ProductLoader productLoader = new DefaultProductLoader(productRepository,categoryRepository,subCategoryRepository,conditionRepository);

        return productLoader;
    }
}
