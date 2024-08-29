package com.tarefado.springboot.controller;

import com.tarefado.springboot.model.entity.Item;
import com.tarefado.springboot.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> inserir(@RequestBody Item novoItem) {
        Item item = itemService.inserir(novoItem);
        return ResponseEntity.ok(item);
    }

    @PutMapping(path = "/atualizar")
    public ResponseEntity<Item> atualizar(@RequestBody Item atualizado) {
        Item item = itemService.atualizar(atualizado);
        return ResponseEntity.ok(item);
    }

    @GetMapping
    public List<Item> listarTodos() {
        List<Item> itens = itemService.listarTodos();
        return itens;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Item> buscarPorId(@PathVariable("id") Integer id) {
        Item item = itemService.buscarPorId(id);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping(path = "/{id}")
    public boolean excluir(Integer id){
        itemService.excluir(id);
        return true;
    }

}
