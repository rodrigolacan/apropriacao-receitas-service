package rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.tipopagamento.dto;

import java.util.Set;

public record TipoPagamentoDTO(
        String nomeTipoPagamento,
        Set<Integer> viaReciboIds
) {
}