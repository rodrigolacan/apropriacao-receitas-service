package rr.sebrae.apropriacao.app.http.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.tipopagamento.entity.TipoPagamento;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.tipopagamento.service.TipoPagamentoService;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.viarecibo.dto.ViaReciboDTO;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.viarecibo.entity.ViaRecibo;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.viarecibo.service.ViaReciboService;
import rr.sebrae.apropriacao.app.exceptions.http.ResourceNotFoundException;
import rr.sebrae.apropriacao.app.http.responses.ResponseHandler;

import java.util.List;
import java.util.Optional;

@Profile("prod")
@RestController
@RequestMapping("/rest")
public class ViaReciboController {

    @Autowired
    ViaReciboService viaReciboService;

    @Autowired
    TipoPagamentoService tipoPagamentoService;

    @GetMapping("/viarecibos")
    public ResponseEntity<Object> allViaRecibos() {
        List<ViaRecibo> allTipoPagamento = viaReciboService.findAllViaRecibos();
        return ResponseHandler.generateResponse("Via Recibos retornados com sucesso!", HttpStatus.OK, allTipoPagamento);
    }

    @GetMapping("/viarecibos/{id}")
    public ResponseEntity<Object> getViaReciboById(@PathVariable int id) {
        Optional<ViaRecibo> viaRecibo = viaReciboService.findViaReciboById(id);

        return viaRecibo.map(vr -> ResponseHandler.generateResponse("Tipo Pagamento retornado com sucesso!", HttpStatus.OK, vr))
                .orElseThrow(() -> new ResourceNotFoundException("Tipo Pagamento não encontrado para o id " + id));
    }

    @PostMapping("/viarecibos")
    public ResponseEntity<Object> createViaRecibo(@RequestBody ViaReciboDTO viaReciboDTO) {
        // Busca o TipoPagamento pelo ID
        Optional<TipoPagamento> tipoPagamento = tipoPagamentoService.findTipoPagamentoById(viaReciboDTO.tipoPagamentoId());

        //Verifica o retorno do tipo pagamento
        if (tipoPagamento.isEmpty()) {
            throw new ResourceNotFoundException("Tipo Pagamento não encontrado para o id " + viaReciboDTO.tipoPagamentoId());
        }

        ViaRecibo viaRecibo = new ViaRecibo();
        viaRecibo.setUnidade(viaReciboDTO.unidade());
        viaRecibo.setNomeCliente(viaReciboDTO.nomeCliente());
        viaRecibo.setDotacaoOrcamentaria(viaReciboDTO.dotacaoOrcamentaria());
        viaRecibo.setServicoFaturado(viaReciboDTO.servicoFaturado());
        viaRecibo.setDataFinalPrestacaoServico(viaReciboDTO.dataFinalPrestacaoServico());
        viaRecibo.setTipoPagamento(tipoPagamento.get());

        ViaRecibo savedViaRecibo = viaReciboService.saveViaRecibo(viaRecibo);
        return ResponseHandler.generateResponse("Tipo de pagamento criado com sucesso!", HttpStatus.CREATED, savedViaRecibo);
    }
}
