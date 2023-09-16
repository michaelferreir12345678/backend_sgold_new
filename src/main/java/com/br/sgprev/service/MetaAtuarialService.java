package com.br.sgprev.service;

import com.br.sgprev.entity.MetaAtuarial;
import com.br.sgprev.repository.MetaAtuarialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaAtuarialService {

    @Autowired
    private MetaAtuarialRepository metaAtuarialRepository;

    public List<MetaAtuarial> buscarTodos(){
        return metaAtuarialRepository.findAll();
    }

    public MetaAtuarial inserir(MetaAtuarial meta){
        return metaAtuarialRepository.save(meta);
    }

    public MetaAtuarial alterar(MetaAtuarial meta){
        return metaAtuarialRepository.saveAndFlush(meta);
    }

    public void excluir(Long id){
        MetaAtuarial metaAtuarial = metaAtuarialRepository.findById(id).get();
        metaAtuarialRepository.delete(metaAtuarial);
    }




}
