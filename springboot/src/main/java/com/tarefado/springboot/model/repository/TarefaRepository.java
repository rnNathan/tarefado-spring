package com.tarefado.springboot.model.repository;

import com.tarefado.springboot.model.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}