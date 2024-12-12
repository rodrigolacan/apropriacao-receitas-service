package rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.tipopagamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.tipopagamento.entity.TipoPagamento;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.tipopagamento.repository.TipoPagamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Profile("dev")
public class TipoPagamentoService {
    @Autowired
    private TipoPagamentoRepository tipoPagamentoRepository;

    public List<TipoPagamento> findAllTipoPagamento() {
        return tipoPagamentoRepository.findAll();
    }

    public Optional<TipoPagamento> findTipoPagamentoById(Integer id) {
        return tipoPagamentoRepository.findById(id);
    }

    public TipoPagamento saveTipoPagamento(TipoPagamento tipoPagamento) {
        return tipoPagamentoRepository.save(tipoPagamento);
    }
}
