package com.musicbridge.marketplace.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.musicbridge.marketplace.domain.Category;
import com.musicbridge.marketplace.domain.Condition;
import com.musicbridge.marketplace.domain.SubCategory;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@JsonDeserialize(as = ProductInformation.class)
@Setter
@ToString
@Getter
@AllArgsConstructor
public class ProductInformation {

    private UUID id;

    private String name;

    private BigDecimal price;

    private String brand;

    private String description;

    private SubCategory subCategory;

    private Condition condition;

    private String imagesPath;

    private String videosPath;

    private UUID createdBy;

    private LocalDateTime createdDate;
}
