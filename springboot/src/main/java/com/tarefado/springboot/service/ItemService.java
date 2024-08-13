package com.tarefado.springboot.service;

import com.tarefado.springboot.model.entity.Item;
import com.tarefado.springboot.model.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item inserir(Item itemEntity) {
        return itemRepository.save(itemEntity);
    }

    public Item atualizar(@RequestBody Item atualizarItem) {
        return itemRepository.save(atualizarItem);
    }

    public Item buscarPorId(Integer id){
        return itemRepository.findById(id.longValue()).get();
    }

    public List<Item> listarTodos() {
        return itemRepository.findAll();
    }

    public boolean excluir(Integer id ){
        itemRepository.deleteById(id.longValue());
        return true;
    }

}
