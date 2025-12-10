package com.example.kanbanpro.repository;

import com.example.kanbanpro.domain.Column;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColumnRepository extends JpaRepository<Column, Long> {
}

