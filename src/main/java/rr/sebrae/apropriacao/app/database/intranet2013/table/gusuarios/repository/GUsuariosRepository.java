package rr.sebrae.apropriacao.app.database.intranet2013.table.gusuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rr.sebrae.apropriacao.app.database.intranet2013.table.gusuarios.entity.GUsuarios;

@Repository
public interface GUsuariosRepository extends JpaRepository<GUsuarios, Long> {
}
