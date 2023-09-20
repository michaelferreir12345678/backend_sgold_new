package com.br.sgprev.controller;

import com.br.sgprev.entity.StatusUsuario;
import com.br.sgprev.entity.Usuario;
import com.br.sgprev.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @CrossOrigin()
    @PostMapping("/users/register")
    public StatusUsuario registrarUsuario(@Valid @RequestBody Usuario newUser) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        for (Usuario usuario : usuarios) {
            if (usuario.equals(newUser)) {
                System.out.println("User Already exists!");
                return StatusUsuario.USER_ALREADY__EXISTS;
            }
        }
        usuarioRepository.save(newUser);
        return StatusUsuario.SUCESS;
    }

    @CrossOrigin()
    @PostMapping("/users/login")
    public StatusUsuario loginUsuario(@Valid @RequestBody Usuario usuario) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        for (Usuario outro : usuarios) {
            if (outro.equals(usuario)) {
                outro.setLoggedIn(true);
                usuarioRepository.saveAndFlush(outro);
                return StatusUsuario.SUCESS;
            }
        }
        return StatusUsuario.FAILURE;
    }
    @PostMapping("/users/logout")
    public StatusUsuario logUsuarioOut(@RequestBody Usuario usuario) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        for (Usuario outro : usuarios) {
            if (outro.equals(usuario)) {
                outro.setLoggedIn(false);
                usuarioRepository.saveAndFlush(outro);
                return StatusUsuario.SUCESS;
            }
        }
        return StatusUsuario.FAILURE;
    }

    @DeleteMapping("/users/all")
    public StatusUsuario deleteUsuarios() {
        usuarioRepository.deleteAll();
        return StatusUsuario.SUCESS;
    }
}