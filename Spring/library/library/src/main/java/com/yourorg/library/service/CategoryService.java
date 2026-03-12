package com.yourorg.library.service;

import com.yourorg.library.entity.Category;
import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    List<Category> getAllCategories();
}