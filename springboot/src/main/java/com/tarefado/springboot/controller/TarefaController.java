package com.tarefado.springboot.controller;


import com.tarefado.springboot.exception.TarefaException;
import com.tarefado.springboot.model.dto.TemplateDTO;
import com.tarefado.springboot.model.entity.Item;
import com.tarefado.springboot.model.entity.Tarefa;
import com.tarefado.springboot.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Tarefa> inserir(@RequestBody Tarefa novaTarefa) throws TarefaException {
        return ResponseEntity.ok(tarefaService.inserir(novaTarefa));
    }

    @PostMapping(path = "/template")
    public ResponseEntity<Tarefa> criarTarefaTemplate(@RequestBody TemplateDTO templateDTO) throws TarefaException {
        return ResponseEntity.ok(tarefaService.criarTarefaTemplate(templateDTO));
    }

    @PutMapping(path = "/atualizar")
    public ResponseEntity<Tarefa> atualizar(@RequestBody Tarefa atualizar) {
        return ResponseEntity.ok(tarefaService.atualizar(atualizar));
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
