package rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.viarecibo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.viarecibo.entity.ViaRecibo;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.viarecibo.repository.ViaReciboRepository;
import rr.sebrae.apropriacao.app.exceptions.http.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Profile("prod")
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

    public ViaRecibo softDeleteViaReciboById(Integer id) {
        Optional<ViaRecibo> viaReciboOptional = viaReciboRepository.findById(id);

        if (viaReciboOptional.isEmpty()) {
            throw new ResourceNotFoundException("A ViaRecibo com o ID " + id + " não foi encontrado.");
        }
        ViaRecibo viaRecibo = viaReciboOptional.get();
        viaRecibo.setDeletedAt(LocalDateTime.now());
        return viaReciboRepository.save(viaRecibo);
    }

}
