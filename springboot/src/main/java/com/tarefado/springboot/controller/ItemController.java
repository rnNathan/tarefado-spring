package com.tarefado.springboot.controller;

import com.tarefado.springboot.model.entity.Item;
import com.tarefado.springboot.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public Item inserir(@RequestBody Item itemEntity) {
        return itemService.inserir(itemEntity);
    }

    @PutMapping(path = "/atualizar")
    public Item atualizar(@RequestBody Item itemEntity) {
        return itemService.atualizar(itemEntity);
    }

    @GetMapping
    public List<Item> listarTodos() {
        List<Item> itens = itemService.listarTodos();
        return itens;
    }

    @GetMapping(path = "/{id}")
    public Item buscarPorId(@PathVariable("id") Integer id) {
        Item item = itemService.buscarPorId(id);
        return item;
    }

    @DeleteMapping(path = "/{id}")
    public boolean excluir(Integer id){
        itemService.excluir(id);
        return true;
    }

}
