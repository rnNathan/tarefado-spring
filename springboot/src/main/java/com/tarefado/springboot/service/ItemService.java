package com.tarefado.springboot.service;

import com.tarefado.springboot.model.entity.ItemEntity;
import com.tarefado.springboot.model.entity.TarefaEntity;
import com.tarefado.springboot.model.repository.ItemRepository;
import com.tarefado.springboot.model.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ItemEntity inserir ( ItemEntity itemEntity) {
        return itemRepository.save(itemEntity);
    }

    public ItemEntity atualizar (ItemEntity atualizarItem) {
        return itemRepository.save(atualizarItem);
    }

    public ItemEntity buscarPorId(Integer id){
        return itemRepository.findById(id.intValue()).get();
    }

    public List<ItemEntity> listarTodos () {
        return itemRepository.findAll();
    }

    public boolean excluir (Integer id ){
        itemRepository.deleteById(id.intValue());
        return true;
    }

}
