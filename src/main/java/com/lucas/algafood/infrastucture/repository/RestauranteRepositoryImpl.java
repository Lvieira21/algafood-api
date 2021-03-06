package com.lucas.algafood.infrastucture.repository;

import com.lucas.algafood.domain.model.Restaurante;
import com.lucas.algafood.domain.repository.RestauranteRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> getRestaurantes() {
        TypedQuery<Restaurante> query = manager.createQuery("from Restaurante", Restaurante.class);

        return query.getResultList();
    }

    @Override
    public Restaurante getRestauranteById(Long id) {
        return manager.find(Restaurante.class, id);
    }

    @Transactional
    @Override
    public Restaurante setRestaurante(Restaurante restaurante) {
        return manager.merge(restaurante);
    }

    @Transactional
    @Override
    public void deleteRestaurante(Restaurante restaurante) {
        restaurante = getRestauranteById(restaurante.getId());

        manager.remove(restaurante);
    }
}
