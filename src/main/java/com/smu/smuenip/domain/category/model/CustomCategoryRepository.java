package com.smu.smuenip.domain.category.model;

import java.util.Optional;

public interface CustomCategoryRepository {

    Optional<Category> findCategoryByCategoryId(Long categoryId);

    Category findCategoryByDetailCategory(
        String detailCategory);

    Category findCategoryByDetailCategoryOrSubCategory(String detailCategory, String subCategory);
}