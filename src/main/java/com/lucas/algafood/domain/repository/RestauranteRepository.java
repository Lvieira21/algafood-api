package com.lucas.algafood.domain.repository;

import com.lucas.algafood.domain.model.Cozinha;
import com.lucas.algafood.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> getRestaurantes();
    Restaurante getRestauranteById(Long Id);
    Restaurante setRestaurante(Restaurante restaurante);
    void deleteRestaurante(Restaurante restaurante);
}
