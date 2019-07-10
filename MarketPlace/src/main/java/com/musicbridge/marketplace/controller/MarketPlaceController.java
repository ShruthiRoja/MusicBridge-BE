package com.musicbridge.marketplace.controller;

import com.musicbridge.marketplace.dto.request.ProductCreateRequest;
import com.musicbridge.marketplace.dto.request.ProductUpdateRequest;
import com.musicbridge.marketplace.dto.response.ProductInformation;
import com.musicbridge.marketplace.service.MarketPlaceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class MarketPlaceController {

    @Autowired
    MarketPlaceService marketPlaceService;

    @ApiOperation(value = "Creates a new product", notes = "Creates a new product")
    @PostMapping( value ="/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductInformation addProduct(@ApiParam("Create a product")
                                         @RequestBody @Valid ProductCreateRequest productCreateRequest) {
        return marketPlaceService.createProduct(productCreateRequest);
    }

    @ApiOperation(value = "Delete product by product id", notes = "Delete product")
    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("productId") UUID productId) {
        marketPlaceService.deleteProduct(productId);
    }

    @ApiOperation(value = "Update the product", notes = "Update the product")
    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/{productId}")
    public ProductInformation updateProduct(@ApiParam(value = " Product Id", required = true)
                                            @PathVariable("productId") UUID productId,
                                            @ApiParam(value = "Product update request", required = true)
                                            @RequestBody @Valid ProductUpdateRequest productUpdateRequest) {
        return marketPlaceService.updateProduct(productId,productUpdateRequest);
    }

    @ApiOperation(value = "Get the product", notes = "Gets the productInformation")
    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductInformation getProduct(@ApiParam(value = "product Id") @PathVariable("productId") UUID productId) {
        return marketPlaceService.getProduct(productId);
    }
}
