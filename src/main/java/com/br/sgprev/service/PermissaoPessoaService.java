package com.br.sgprev.service;

import java.util.Date;
import java.util.List;

import com.br.sgprev.entity.Permissao;
import com.br.sgprev.entity.PermissaoPessoa;
import com.br.sgprev.entity.Pessoa;
import com.br.sgprev.repository.PermissaoPessoaRepository;
import com.br.sgprev.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissaoPessoaService {
    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;
    @Autowired
    private PermissaoRepository permissaoRepository;
    public void vincularPessoaPermissaoCliente(Pessoa pessoa) {
        List<Permissao> listaPermissao = permissaoRepository.findByNome("cliente");
        if (listaPermissao.size() > 0) {
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setDataCriacao(new Date());
            permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
        }
    }

}