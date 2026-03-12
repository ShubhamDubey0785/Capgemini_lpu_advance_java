package com.yourorg.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yourorg.library.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}