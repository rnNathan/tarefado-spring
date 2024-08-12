package com.tarefado.springboot.controller;

import com.tarefado.springboot.model.entity.ItemEntity;
import com.tarefado.springboot.model.entity.TarefaEntity;
import com.tarefado.springboot.service.ItemService;
import com.tarefado.springboot.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ItemEntity inserir (ItemEntity itemEntity) {
        return itemService.inserir(itemEntity);
    }

    @PutMapping(path = "/atualizar")
    public ItemEntity atualizar (@RequestBody ItemEntity itemEntity) {
        return itemService.atualizar(itemEntity);
    }

    @GetMapping
    public List<ItemEntity> listarTodos() {
        List<ItemEntity> itens = itemService.listarTodos();
        return itens;
    }

    @GetMapping(path = "/{id}")
    public ItemEntity buscarPorId (@PathVariable("id") Integer id) {
        ItemEntity item = itemService.buscarPorId(id);
        return item;
    }

    @DeleteMapping(path = "/{id}")
    public boolean excluir (Integer id){
        itemService.excluir(id);
        return true;
    }

}
