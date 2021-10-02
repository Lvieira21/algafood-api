package com.lucas.algafood.domain.repository;

import com.lucas.algafood.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> getEstados();
    Estado getEstadoById(Long id);
    Estado setEstado(Estado estado);
    void removeEstado(Estado estado);
}
