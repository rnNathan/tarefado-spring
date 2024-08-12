package com.tarefado.springboot.service;

import com.tarefado.springboot.model.entity.UsuarioEntity;
import com.tarefado.springboot.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioEntity inserir (UsuarioEntity usuarioEntity){
        return  usuarioRepository.save(usuarioEntity);
    }

    public UsuarioEntity atualizar (UsuarioEntity atualizarUsuario){
        return usuarioRepository.save(atualizarUsuario);
    }

    public List<UsuarioEntity> listarTodos() {
        return usuarioRepository.findAll();
    }

    public UsuarioEntity buscarPorId(Integer id){
        return usuarioRepository.findById(id.intValue()).get();
    }

    public boolean excluir (Integer id) {
        usuarioRepository.deleteById(id.intValue());
        return true;
    }


}
