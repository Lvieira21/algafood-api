package com.lucas.algafood.domain.repository;

import com.lucas.algafood.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {

    List<Cidade> getCidades();
    Cidade getCidadeById(Long Id);
    Cidade setCidade(Cidade cidade);
    void removeCidade(Cidade cidade);
}
