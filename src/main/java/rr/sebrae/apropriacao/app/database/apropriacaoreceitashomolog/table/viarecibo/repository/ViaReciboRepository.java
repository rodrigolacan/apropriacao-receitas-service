package rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.viarecibo.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.viarecibo.entity.ViaRecibo;

import java.util.List;

@Repository
@Profile("dev")
public interface ViaReciboRepository extends JpaRepository<ViaRecibo, Integer> {
    @Query("SELECT vr FROM ViaRecibo vr WHERE vr.deletedAt IS NULL")
    List<ViaRecibo> findAllActiveViaRecibos();

}
