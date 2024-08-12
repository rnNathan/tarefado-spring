package com.tarefado.springboot.model.repository;

import com.tarefado.springboot.model.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
}
