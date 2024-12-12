package rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.tipopagamento.dto;

import java.util.Set;

public record TipoPagamentoDTO(
        Integer id,
        String nomeTipoPagamento,
        Set<Integer> viaReciboIds
) {
}