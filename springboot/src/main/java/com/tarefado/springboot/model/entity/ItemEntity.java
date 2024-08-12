package com.tarefado.springboot.model.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tarefa_id")
    private TarefaEntity idTarefa;

    @Column(nullable = false)
    private String descricao;

    private Boolean realizado;

}
