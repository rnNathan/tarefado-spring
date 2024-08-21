package com.tarefado.springboot.controller;


import com.tarefado.springboot.exception.TarefaException;
import com.tarefado.springboot.model.dto.TemplateDTO;
import com.tarefado.springboot.model.entity.Tarefa;
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
    public Tarefa inserir(@RequestBody Tarefa tarefaEntity) {
        return tarefaService.inserir(tarefaEntity);
    }

    @PostMapping(path = "/template")
    public Tarefa criarTarefaTemplate(TemplateDTO templateDTO) throws TarefaException {
        return tarefaService.criarTarefaTemplate(templateDTO);
    }

    @PutMapping(path = "/atualizar")
    public Tarefa atualizar(@RequestBody Tarefa tarefaEntity) {
        return tarefaService.atualizar(tarefaEntity);
    }

    @GetMapping
    public List<Tarefa> listarTodos() {
        List<Tarefa> tarefas = tarefaService.listarTodos();
        return tarefas;
    }

    @GetMapping(path = "/{id}")
    public Tarefa buscarPorId(@PathVariable Integer id) {
        Tarefa tarefa = tarefaService.buscarPorId(id);
        return tarefa;
    }

    @DeleteMapping(path = "/{id}")
    public boolean excluir(Integer id){
        tarefaService.excluir(id);
        return true;
    }



}
