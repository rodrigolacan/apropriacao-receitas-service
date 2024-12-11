package rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.viarecibo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.viarecibo.entity.ViaRecibo;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.viarecibo.repository.ViaReciboRepository;

import java.util.List;

@Service
@Profile("dev")
public class ViaReciboService {
    @Autowired
    private ViaReciboRepository viaReciboRepository;

    public List<ViaRecibo> getAllViaRecibos() {
        return viaReciboRepository.findAll();
    }
}
