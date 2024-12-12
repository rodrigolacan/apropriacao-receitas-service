package rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.tipopagamento.dto;

import java.util.Set;

public record TipoPagamentoDTO(
        Integer id,
        String nomeTipoPagamento,
        Set<Integer> viaReciboIds
) {
}