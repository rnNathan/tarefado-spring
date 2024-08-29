package com.tarefado.springboot.controller;

import com.tarefado.springboot.model.entity.Usuario;
import com.tarefado.springboot.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<Usuario> inserir(@RequestBody Usuario inserir) {
        return ResponseEntity.ok(usuarioService.inserir(inserir));
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario atualizarUsuario) {
        return ResponseEntity.ok(usuarioService.atualizar(atualizarUsuario))    ;
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = usuarioService.listarTodos();
        return usuarios;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @DeleteMapping(path = "/{id}")
    public boolean excluir(Integer id){
        usuarioService.excluir(id);
        return true;
    }
}
