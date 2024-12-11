package rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.viarecibo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.viarecibo.repository.ViaReciboRepository;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.viarecibo.entity.ViaRecibo;

import java.util.List;

@Service
@Profile("pro")
public class ViaReciboService {

    @Autowired
    private ViaReciboRepository viaReciboRepository;

    public List<ViaRecibo> getAllViaRecibos() {
        return viaReciboRepository.findAll();
    }

}
