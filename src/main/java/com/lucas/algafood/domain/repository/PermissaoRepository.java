package com.lucas.algafood.domain.repository;

import com.lucas.algafood.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    List<Permissao> getPermissoes();
    Permissao getPermissaoById(Long Id);
    void setPermissao(Permissao permissao);
    void deletePermissao(Permissao permissao);
}
