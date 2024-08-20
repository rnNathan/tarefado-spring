package com.tarefado.springboot.service;

import com.tarefado.springboot.model.entity.Tarefa;
import com.tarefado.springboot.model.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa inserir(Tarefa tarefaEntity) {
        return tarefaRepository.save(tarefaEntity);
    }

    public Tarefa atualizar(Tarefa atualiazarTarefa) {
        return tarefaRepository.save(atualiazarTarefa);
    }

    public Tarefa buscarPorId(Integer id){
        return tarefaRepository.findById(id.longValue()).get();
    }

    public List<Tarefa> listarTodos() {
        return tarefaRepository.findAll();
    }

    public boolean excluir(Integer id ){
        tarefaRepository.deleteById(id.longValue());
        return true;
    }

}
