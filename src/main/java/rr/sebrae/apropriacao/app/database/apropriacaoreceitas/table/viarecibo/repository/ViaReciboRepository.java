package rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.viarecibo.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.viarecibo.entity.ViaRecibo;

@Repository
@Profile("prod")
public interface ViaReciboRepository extends JpaRepository<ViaRecibo, Integer> {
}
