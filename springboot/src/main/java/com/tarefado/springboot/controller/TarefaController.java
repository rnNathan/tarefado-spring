package com.tarefado.springboot.controller;


import com.tarefado.springboot.model.entity.TarefaEntity;
import com.tarefado.springboot.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public TarefaEntity inserir (TarefaEntity tarefaEntity) {
        return tarefaService.inserir(tarefaEntity);
    }

    @PutMapping(path = "/atualizar")
    public TarefaEntity atualizar (@RequestBody TarefaEntity tarefaEntity) {
        return tarefaService.atualizar(tarefaEntity);
    }

    @GetMapping
    public List<TarefaEntity> listarTodos() {
        List<TarefaEntity> tarefas = tarefaService.listarTodos();
        return tarefas;
    }

    @GetMapping(path = "/{id}")
    public TarefaEntity buscarPorId (@PathVariable("id") Integer id) {
        TarefaEntity tarefa = tarefaService.buscarPorId(id);
        return tarefa;
    }

    @DeleteMapping(path = "/{id}")
    public boolean excluir (Integer id){
        tarefaService.excluir(id);
        return true;
    }

}
