package rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.viarecibo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.viarecibo.entity.ViaRecibo;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.viarecibo.repository.ViaReciboRepository;

import java.util.List;
import java.util.Optional;

@Service
@Profile("dev")
public class ViaReciboService {
    @Autowired
    private ViaReciboRepository viaReciboRepository;

    public List<ViaRecibo> findAllViaRecibos() {
        return viaReciboRepository.findAll();
    }

    public Optional<ViaRecibo> findViaReciboById(Integer id) {
        return viaReciboRepository.findById(id);
    }

    public ViaRecibo saveViaRecibo(ViaRecibo viaRecibo) {
        return viaReciboRepository.save(viaRecibo);
    }
}
