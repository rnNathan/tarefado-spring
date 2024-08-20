package com.tarefado.springboot.service;

import com.tarefado.springboot.model.entity.Usuario;
import com.tarefado.springboot.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario inserir(Usuario usuarioEntity){
        return  usuarioRepository.save(usuarioEntity);
    }

    public Usuario atualizar(Usuario atualizarUsuario){
        return usuarioRepository.save(atualizarUsuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer id){
        return usuarioRepository.findById(id.longValue()).get();
    }

    public boolean excluir(Integer id) {
        usuarioRepository.deleteById(id.longValue());
        return true;
    }


}
