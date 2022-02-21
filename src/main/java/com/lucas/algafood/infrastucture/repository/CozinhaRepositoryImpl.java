package com.lucas.algafood.infrastucture.repository;

import com.lucas.algafood.domain.model.Cozinha;
import com.lucas.algafood.domain.repository.CozinhaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cozinha> getCozinhas() {
        TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class); //Cria consulta

        return query.getResultList();
    }

    @Override
    public Cozinha getCozinhaById(Long id) {
        return manager.find(Cozinha.class, id);
    }

    @Transactional
    @Override
    public Cozinha setCozinha(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    @Transactional
    @Override
    public void deleteCozinha(Long cozinhaId) {
        Cozinha cozinha = getCozinhaById(cozinhaId);

        if (cozinha == null) {
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(cozinha);
    }
}
