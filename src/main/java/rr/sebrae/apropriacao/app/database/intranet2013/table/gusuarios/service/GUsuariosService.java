package rr.sebrae.apropriacao.app.database.intranet2013.table.gusuarios.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import rr.sebrae.apropriacao.app.database.intranet2013.table.gusuarios.entity.GUsuarios;
import rr.sebrae.apropriacao.app.database.intranet2013.table.gusuarios.repository.GUsuariosRepository;


import java.util.List;

@Service
public class GUsuariosService {
    @Autowired
    GUsuariosRepository GUsuariosRepository;

    public List<GUsuarios> findAll(){
        return GUsuariosRepository.findAll();
    }
}
