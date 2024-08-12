package com.tarefado.springboot.service;

import com.tarefado.springboot.model.entity.TarefaEntity;
import com.tarefado.springboot.model.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefaEntity inserir (@RequestBody TarefaEntity tarefaEntity) {
        return tarefaRepository.save(tarefaEntity);
    }

    public TarefaEntity atualizar (TarefaEntity atualiazarTarefa) {
        return tarefaRepository.save(atualiazarTarefa);
    }

    public TarefaEntity buscarPorId(Integer id){
        return tarefaRepository.findById(id.intValue()).get();
    }

    public List<TarefaEntity> listarTodos () {
        return tarefaRepository.findAll();
    }

    public boolean excluir (Integer id ){
        tarefaRepository.deleteById(id.intValue());
        return true;
    }

}
