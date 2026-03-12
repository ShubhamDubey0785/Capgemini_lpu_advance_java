package com.yourorg.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yourorg.library.entity.LibraryBranch;

public interface LibraryBranchRepository extends JpaRepository<LibraryBranch, Long> {
}