package rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.viarecibo.dto;

import java.time.LocalDate;

public record ViaReciboDTO(
        String nomeCliente,
        Integer tipoPagamentoId,
        String servicoFaturado,
        String unidade,
        String dotacaoOrcamentaria,
        String dataFinalPrestacaoServico,
        LocalDate createdAt,
        LocalDate deletedAt
) {
}
