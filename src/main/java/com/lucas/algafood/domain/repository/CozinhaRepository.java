package com.lucas.algafood.domain.repository;

import com.lucas.algafood.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {

    List<Cozinha> getCozinhas();
    Cozinha getCozinhaById(Long id);
    Cozinha setCozinha(Cozinha cozinha);
    void deleteCozinha(Long id);

}
