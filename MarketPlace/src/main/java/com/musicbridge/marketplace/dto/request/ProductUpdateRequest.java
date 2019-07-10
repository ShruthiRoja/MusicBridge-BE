package com.musicbridge.marketplace.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@JsonDeserialize(as = ProductUpdateRequest.class)
@AllArgsConstructor
@Getter
@Setter
public class ProductUpdateRequest {

    @ApiModelProperty(value = "product Name", required = true)
    private String name;

    @ApiModelProperty(value = "categoryId", required = true)
    private int categoryId;

    @ApiModelProperty(value = "price", required = true)
    private BigDecimal price;

    @ApiModelProperty(value = "Brand", required = false)
    String brand;

    @ApiModelProperty(value = "Description", required = false)
    String description;

    @ApiModelProperty(value = "SubCategoryId", required = true)
    Integer subCategoryId;

    @ApiModelProperty(value = "ConditionId", required = true)
    Integer conditionId;

    @ApiModelProperty(value = "ImagesPath", required = true)
    String imagesPath;

    @ApiModelProperty(value = "VideosPath", required = false)
    String videosPath;

    @ApiModelProperty(value = "ContactVia", required = false)
    String contactDetails;
}
