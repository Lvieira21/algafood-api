package com.lucas.algafood.domain.service;

import com.lucas.algafood.domain.exceptions.EntidadeEmUsoException;
import com.lucas.algafood.domain.model.Cozinha;
import com.lucas.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha setCozinha(Cozinha cozinha) {
        return cozinhaRepository.setCozinha(cozinha);
    }

    public void removeCozinha(Long id) {
        try {
            cozinhaRepository.deleteCozinha(id);

        }
        catch (EmptyResultDataAccessException e) {
            throw new EntidadeEmUsoException(String.format("Não existe uma cozinha com o código %d", id));
        }
        catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("Cozinha de código %d não pode ser removida, pois está em uso", id));
        }
    }
}
