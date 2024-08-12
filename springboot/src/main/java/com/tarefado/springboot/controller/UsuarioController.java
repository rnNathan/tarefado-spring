package com.tarefado.springboot.controller;

import com.tarefado.springboot.model.entity.TarefaEntity;
import com.tarefado.springboot.model.entity.UsuarioEntity;
import com.tarefado.springboot.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public UsuarioEntity inserir(UsuarioEntity inserir) {
        return usuarioService.inserir(inserir);
    }

    @PutMapping
    public UsuarioEntity atualizar(UsuarioEntity atualizarUsuario) {
        return usuarioService.atualizar(atualizarUsuario);
    }

    @GetMapping
    public List<UsuarioEntity> listarTodos() {
        List<UsuarioEntity> usuarios = usuarioService.listarTodos();
        return usuarios;
    }

    @GetMapping(path = "/{id}")
    public UsuarioEntity buscarPorId (@PathVariable ("id") Integer id) {
        UsuarioEntity usuario = usuarioService.buscarPorId(id);
        return usuario;
    }

    @DeleteMapping(path = "/{id}")
    public boolean excluir (Integer id){
        usuarioService.excluir(id);
        return true;
    }
}
