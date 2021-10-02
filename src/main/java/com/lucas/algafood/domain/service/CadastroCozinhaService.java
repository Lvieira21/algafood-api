package com.lucas.algafood.domain.service;

import com.lucas.algafood.domain.model.Cozinha;
import com.lucas.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha setCozinha(Cozinha cozinha) {
        return cozinhaRepository.setCozinha(cozinha);
    }
}
