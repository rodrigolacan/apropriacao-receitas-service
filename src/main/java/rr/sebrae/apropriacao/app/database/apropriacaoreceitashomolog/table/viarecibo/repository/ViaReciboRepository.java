package rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.viarecibo.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.viarecibo.entity.ViaRecibo;

@Repository
@Profile("dev")
public interface ViaReciboRepository extends JpaRepository<ViaRecibo, Integer> {

}
