package com.br.sgprev.service;


import com.br.sgprev.entity.MetaAtuarial;
import com.br.sgprev.entity.Usuario;
import com.br.sgprev.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

//    public Usuario alterar(Usuario user){
//        return usuarioRepository.saveAndFlush(user);
//    }
//
//    public void excluir(String id){
//        Usuario usuario = usuarioRepository.findById(id).get();
//        usuarioRepository.delete(usuario);
//    }

}
