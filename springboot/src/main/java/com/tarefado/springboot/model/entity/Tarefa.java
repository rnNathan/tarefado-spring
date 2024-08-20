package com.tarefado.springboot.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "TB_TAREFA")
@Data
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario idUsuario;

    @OneToMany(mappedBy = "idTarefa")
    private List<Item> item;

    @Column(nullable = false)
    private String nomeTarefa;

    @Column(nullable = false)
    private String tipoTarefa;

    private Boolean realizado;
    private Boolean isTemplate;
}
