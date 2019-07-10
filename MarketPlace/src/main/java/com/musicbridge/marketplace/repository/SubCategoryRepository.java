package com.musicbridge.marketplace.repository;

import com.musicbridge.marketplace.domain.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Integer> {

    SubCategory findByIdAndCategoryId(Integer CategoryId , Integer Id );
}
