package com.br.sgprev.entity;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

    @Entity
    @Table(name = "pessoa")
    @Data
    public class Pessoa  implements UserDetails{

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String nome;
        private String cpf;
        private String email;
        private String codigoRecuperacaoSenha;
        @Temporal(TemporalType.TIMESTAMP)
        private Date dataEnvioCodigo;
        private String senha;
        private String endereco;
        private String cep;


        @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
        @Setter(value = AccessLevel.NONE)
        private List<PermissaoPessoa> permissaoPessoas;

        @Temporal(TemporalType.TIMESTAMP)
        private Date dataCriacao;
        @Temporal(TemporalType.TIMESTAMP)
        private Date dataAtualizacao;

        public void setPermissaoPessoas(List<PermissaoPessoa> pp){
            for(PermissaoPessoa p:pp){
                p.setPessoa(this);
            }
            this.permissaoPessoas = pp;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {

            return permissaoPessoas;
        }

        @Override
        public String getPassword() {
            return senha;
        }

        @Override
        public String getUsername() {
            return email;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
