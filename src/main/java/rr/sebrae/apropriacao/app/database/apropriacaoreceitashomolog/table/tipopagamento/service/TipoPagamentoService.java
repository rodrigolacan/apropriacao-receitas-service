package rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.tipopagamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.tipopagamento.entity.TipoPagamento;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.tipopagamento.repository.TipoPagamentoRepository;

import java.util.List;

@Service
@Profile("dev")
public class TipoPagamentoService {
    @Autowired
    private TipoPagamentoRepository tipoPagamentoRepository;

    public List<TipoPagamento> findAllTipoPagamento() {
        return tipoPagamentoRepository.findAll();
    }
}
