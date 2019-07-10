package com.musicbridge.marketplace.builder.factory;

import com.musicbridge.marketplace.builder.Impl.DefaultProductBuilder;
import com.musicbridge.marketplace.builder.ProductBuilder;
import com.musicbridge.marketplace.repository.CategoryRepository;
import com.musicbridge.marketplace.repository.ConditionRepository;
import com.musicbridge.marketplace.repository.ProductRepository;
import com.musicbridge.marketplace.repository.SubCategoryRepository;

public class ProductBuilderFactory {

    public static ProductBuilder getProductBuilder(ProductRepository productRepository,
                                     CategoryRepository categoryRepository ,
                                     SubCategoryRepository subCategoryRepository,
                                     ConditionRepository conditionRepository)
    {
        return new DefaultProductBuilder(productRepository,categoryRepository,
                subCategoryRepository,conditionRepository);
    }
}
