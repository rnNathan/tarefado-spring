package com.tarefado.springboot.model.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TB_ITEM")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tarefa_id")
    private Tarefa idTarefa;

    @Column(nullable = false)
    private String descricao;

    private Boolean realizado;

}
