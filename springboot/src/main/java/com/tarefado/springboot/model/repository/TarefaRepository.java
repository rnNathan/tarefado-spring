package com.tarefado.springboot.model.repository;

import com.tarefado.springboot.model.entity.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository <TarefaEntity, Integer> {

}