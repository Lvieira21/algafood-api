package com.lucas.algafood.domain.service;

import com.lucas.algafood.domain.model.Restaurante;
import com.lucas.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante setRestaurante(Restaurante restaurante) {
        return restauranteRepository.setRestaurante(restaurante);
    }
}
