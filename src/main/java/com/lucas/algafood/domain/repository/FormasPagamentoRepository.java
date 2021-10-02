package com.lucas.algafood.domain.repository;

import com.lucas.algafood.domain.model.FormaPagamento;

import javax.persistence.Entity;
import java.util.List;

public interface FormasPagamentoRepository {

    List<FormaPagamento> getFormasPagamento();
    FormaPagamento getFormaPagamentoById(Long Id);
    void setFormaPagamento(FormaPagamento formaPagamento);
    void deleteFormaPagamento(FormaPagamento formaPagamento);
}
