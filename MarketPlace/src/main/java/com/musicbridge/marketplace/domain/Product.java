package com.musicbridge.marketplace.domain;

import com.musicbridge.framework.AbstractBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "[Product]")
@NoArgsConstructor
@Setter
@Getter
public class Product extends AbstractBaseEntity {

    @Column(name = "Name", nullable = false)
    String name;

    @Column(name = "Price", nullable = false)
    BigDecimal price;

    @Column(name = "Brand")
    String brand;

    @Column(name = "Description")
    String description;

    @Column(name = "ConditionId")
    Integer conditionId;

    @Column(name = "CategoryId", nullable = false)
    Integer categoryId;

    @Column(name = "SubCategoryId", nullable = false)
    Integer subCategoryId;

    @Column(name = "ImagesPath")
    String imagesPath;

    @Column(name = "VideosPath")
    String videosPath;

}
