package com.tarefado.springboot.controller;

import com.tarefado.springboot.model.entity.Usuario;
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
    public Usuario inserir(@RequestBody Usuario inserir) {
        return usuarioService.inserir(inserir);
    }

    @PutMapping
    public Usuario atualizar(@RequestBody Usuario atualizarUsuario) {
        return usuarioService.atualizar(atualizarUsuario);
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = usuarioService.listarTodos();
        return usuarios;
    }

    @GetMapping(path = "/{id}")
    public Usuario buscarPorId(@PathVariable ("id") Integer id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return usuario;
    }

    @DeleteMapping(path = "/{id}")
    public boolean excluir(Integer id){
        usuarioService.excluir(id);
        return true;
    }
}
