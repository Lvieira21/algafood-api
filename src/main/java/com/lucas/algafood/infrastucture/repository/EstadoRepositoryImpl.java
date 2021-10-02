package com.lucas.algafood.infrastucture.repository;

import com.lucas.algafood.domain.model.Estado;
import com.lucas.algafood.domain.repository.EstadoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Estado> getEstados() {
        TypedQuery<Estado> query = manager.createQuery("from Estado", Estado.class);

        return query.getResultList();
    }

    @Override
    public Estado getEstadoById(Long id) {
        return manager.find(Estado.class, id);
    }

    @Override
    public Estado setEstado(Estado estado) {
        return manager.merge(estado);
    }

    @Override
    public void removeEstado(Estado estado) {
        estado = getEstadoById(estado.getId());

        manager.remove(estado);
    }
}
