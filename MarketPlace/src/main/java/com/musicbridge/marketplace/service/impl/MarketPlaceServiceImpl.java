package com.musicbridge.marketplace.service.impl;

import com.musicbridge.marketplace.builder.factory.ProductBuilderFactory;
import com.musicbridge.marketplace.domain.Condition;
import com.musicbridge.marketplace.domain.Product;
import com.musicbridge.marketplace.domain.SubCategory;
import com.musicbridge.marketplace.dto.request.ProductCreateRequest;
import com.musicbridge.marketplace.dto.request.ProductUpdateRequest;
import com.musicbridge.marketplace.dto.response.ProductInformation;
import com.musicbridge.marketplace.loader.ProductLoader;
import com.musicbridge.marketplace.loader.factory.ProductLoaderFactory;
import com.musicbridge.marketplace.removal.factory.ProductRemoverFactory;
import com.musicbridge.marketplace.repository.CategoryRepository;
import com.musicbridge.marketplace.repository.ConditionRepository;
import com.musicbridge.marketplace.repository.ProductRepository;
import com.musicbridge.marketplace.repository.SubCategoryRepository;
import com.musicbridge.marketplace.service.MarketPlaceService;
import com.musicbridge.marketplace.updater.factory.ProductUpdateFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class MarketPlaceServiceImpl implements MarketPlaceService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SubCategoryRepository subCategoryRepository;
    @Autowired
    ConditionRepository conditionRepository;

    public ProductInformation createProduct(ProductCreateRequest productCreateRequest) {

        Product product = ProductBuilderFactory.getProductBuilder(productRepository, categoryRepository,
                subCategoryRepository, conditionRepository).buildProduct(productCreateRequest);

        //Load the product category and subCategory information
        SubCategory subCatgeory = subCategoryRepository.findByIdAndCategoryId( product.getCategoryId(),product.getSubCategoryId());

        Optional<Condition> condition = conditionRepository.findById(product.getConditionId());

        ProductInformation productInformation = ProductLoaderFactory.getProductLoader(productRepository, categoryRepository,
                subCategoryRepository, conditionRepository).convertToProductInformation(product,subCatgeory,condition.get());

        return productInformation;
    }

    public void deleteProduct(UUID productId) {
        ProductRemoverFactory.getProductRemover(productRepository, categoryRepository,
                subCategoryRepository, conditionRepository).deleteProduct(productId);
    }

    public ProductInformation updateProduct( UUID productId ,ProductUpdateRequest productUpdateRequest) {

        Product product = ProductLoaderFactory.getProductLoader(productRepository, categoryRepository,
                subCategoryRepository, conditionRepository).loadByProductId(productId);

        Product updatedProduct = ProductUpdateFactory.getProductUpdater( productRepository,categoryRepository,subCategoryRepository,conditionRepository).updateProduct(product,productUpdateRequest);

        //Load the product category and subCategory information
        SubCategory subCatgeory = subCategoryRepository.findByIdAndCategoryId( product.getCategoryId(),product.getSubCategoryId());

        Condition condition = conditionRepository.getOne(product.getConditionId());


        ProductInformation productInformation = ProductLoaderFactory.getProductLoader(productRepository, categoryRepository,
                subCategoryRepository, conditionRepository).convertToProductInformation(product,subCatgeory,condition);

        return productInformation;
    }

    public ProductInformation getProduct(UUID productId) {
        Product product = ProductLoaderFactory.getProductLoader(productRepository, categoryRepository,
                subCategoryRepository, conditionRepository).loadByProductId(productId);

        //Load the product category and subCategory information
        SubCategory subCatgeory = subCategoryRepository.findByIdAndCategoryId( product.getCategoryId(),product.getSubCategoryId());

        Condition condition = conditionRepository.getOne(product.getConditionId());


        ProductInformation productInformation = ProductLoaderFactory.getProductLoader(productRepository, categoryRepository,
                subCategoryRepository, conditionRepository).convertToProductInformation(product,subCatgeory,condition);

        return productInformation;
    }

}
