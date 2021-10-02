package com.lucas.algafood.infrastucture.repository;

import com.lucas.algafood.domain.model.Permissao;
import com.lucas.algafood.domain.repository.PermissaoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Permissao> getPermissoes() {
        TypedQuery<Permissao> query = manager.createQuery("from Permissao", Permissao.class);

        return query.getResultList();
    }

    @Override
    public Permissao getPermissaoById(Long Id) {
        return manager.find(Permissao.class, Id);
    }

    @Override
    public void setPermissao(Permissao permissao) {
        manager.merge(permissao);
    }

    @Override
    public void deletePermissao(Permissao permissao) {
        permissao = getPermissaoById(permissao.getId());

        manager.remove(permissao);
    }
}
