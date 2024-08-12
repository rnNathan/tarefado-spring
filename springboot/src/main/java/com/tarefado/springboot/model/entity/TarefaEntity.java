package com.tarefado.springboot.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TB_TAREFA")
@Data
public class TarefaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity idUsuario;

    @Column(nullable = false)
    private String nomeTarefa;

    @Column(nullable = false)
    private String tipoTarefa;

    //private Integer<ItemTarefa> itensTarefa;
    private Boolean realizado;
    private Boolean isTemplate;
}
