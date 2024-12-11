package rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.tipopagamento.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.tipopagamento.entity.TipoPagamento;

@Repository
@Profile("prod")
public interface TipoPagamentoRepository extends JpaRepository<TipoPagamento, Integer> {
}
