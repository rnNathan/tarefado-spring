package com.tarefado.springboot.service;

import com.tarefado.springboot.exception.TarefaException;
import com.tarefado.springboot.model.dto.TemplateDTO;
import com.tarefado.springboot.model.entity.Item;
import com.tarefado.springboot.model.entity.Tarefa;
import com.tarefado.springboot.model.repository.ItemRepository;
import com.tarefado.springboot.model.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ItemRepository itemRepository;

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

    public Tarefa criarTarefaTemplate(TemplateDTO templateDTO) throws TarefaException {

        Tarefa tarefaTemplate = tarefaRepository.findById(templateDTO.idTemplate().longValue()).orElse(null);

        if (tarefaTemplate == null || tarefaTemplate.getIsTemplate() == false) {
            throw new TarefaException("Deu ruim");
        }

        Tarefa novaTarefa = new Tarefa();
        novaTarefa.setIdUsuario(tarefaTemplate.getIdUsuario());
        novaTarefa.setNomeTarefa(templateDTO.novoNomeTarefa());
        novaTarefa.setTipoTarefa(tarefaTemplate.getTipoTarefa());
        novaTarefa = tarefaRepository.save(novaTarefa);

        for (Item itemTemplate : tarefaTemplate.getItem()){
            Item novoItem = new Item();
            novoItem.setDescricao(itemTemplate.getDescricao());
            novoItem.setIdTarefa(novaTarefa);

            itemRepository.save(novoItem);

        }

        novaTarefa = tarefaRepository.findById(novaTarefa.getId().longValue()).orElse(null);

        return novaTarefa;
    }

}
