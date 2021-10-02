package com.lucas.algafood.infrastucture.repository;

import com.lucas.algafood.domain.model.Cidade;
import com.lucas.algafood.domain.repository.CidadeRepository;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cidade> getCidades() {
        TypedQuery<Cidade> query = manager.createQuery("from Cidade", Cidade.class);

        return query.getResultList();
    }

    @Override
    public Cidade getCidadeById(Long id) {
        return manager.find(Cidade.class, id);
    }

    @Override
    public Cidade setCidade(Cidade cidade) {
        return manager.merge(cidade);
    }

    @Override
    public void removeCidade(Cidade cidade) {
        cidade = getCidadeById(cidade.getId());

        manager.remove(cidade);
    }
}
