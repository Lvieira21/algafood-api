package com.lucas.algafood.infrastucture.repository;

import com.lucas.algafood.domain.model.FormaPagamento;
import com.lucas.algafood.domain.repository.FormasPagamentoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class FormaPagamentoRepositoryImpl implements FormasPagamentoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<FormaPagamento> getFormasPagamento() {
        TypedQuery<FormaPagamento> query = manager.createQuery("from FormaPagamento", FormaPagamento.class);

        return query.getResultList();
    }

    @Override
    public FormaPagamento getFormaPagamentoById(Long Id) {
        return manager.find(FormaPagamento.class, Id);
    }

    @Override
    public void setFormaPagamento(FormaPagamento formaPagamento) {
        manager.merge(formaPagamento);
    }

    @Override
    public void deleteFormaPagamento(FormaPagamento formaPagamento) {
        formaPagamento = getFormaPagamentoById(formaPagamento.getId());

        manager.remove(formaPagamento);
    }
}
