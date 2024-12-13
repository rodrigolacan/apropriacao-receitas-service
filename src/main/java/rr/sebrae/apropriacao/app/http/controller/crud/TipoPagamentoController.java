package rr.sebrae.apropriacao.app.http.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.tipopagamento.service.TipoPagamentoService;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.tipopagamento.entity.TipoPagamento;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.tipopagamento.dto.TipoPagamentoDTO;
import rr.sebrae.apropriacao.app.exceptions.http.ResourceNotFoundException;
import rr.sebrae.apropriacao.app.http.responses.ResponseHandler;

import java.util.List;
import java.util.Optional;

@Profile("prod")
@RequestMapping("/rest")
@RestController
public class TipoPagamentoController {

    @Autowired
    TipoPagamentoService tipoPagamentoService;

    @GetMapping("/tipopagamento")
    public ResponseEntity<Object> allTipoPagamento() {
        List<TipoPagamento> allTipoPagamento = tipoPagamentoService.findAllTipoPagamentos();
        return ResponseHandler.generateResponse("Tipos Pagamentos retornados com sucesso!", HttpStatus.OK, allTipoPagamento);
    }

    @GetMapping("/tipopagamento/{id}")
    public ResponseEntity<Object> findTipoPagamentoById(@PathVariable int id) {
        Optional<TipoPagamento> tipoPagamento = tipoPagamentoService.findTipoPagamentoById(id);
        return tipoPagamento.map(tp -> ResponseHandler.generateResponse("Tipo Pagamento criado com sucesso!", HttpStatus.OK, tp))
                .orElseThrow(() -> new ResourceNotFoundException("Tipo Pagamento não encontrado para o id " + id));
    }

    @PostMapping("/tipopagamento")
    public ResponseEntity<Object> createTipoPagamento(@RequestBody TipoPagamentoDTO tipoPagamentoDTO) {
        TipoPagamento tipoPagamento = new TipoPagamento();
        tipoPagamento.setNomeTipoPagamento(tipoPagamentoDTO.nomeTipoPagamento());

        // Não passamos o ID manualmente, pois o banco irá gerar.
        TipoPagamento savedTipoPagamento = tipoPagamentoService.saveTipoPagamento(tipoPagamento);

        return ResponseHandler.generateResponse("Tipo de pagamento criado com sucesso!", HttpStatus.CREATED, savedTipoPagamento);
    }

    @PutMapping("/tipopagamento")
    public ResponseEntity<Object> updateTipoPagamento(@RequestBody TipoPagamentoDTO tipoPagamentoDTO) {
        TipoPagamento tipoPagamento = new TipoPagamento();
        tipoPagamento.setId(tipoPagamentoDTO.id());
        tipoPagamento.setNomeTipoPagamento(tipoPagamentoDTO.nomeTipoPagamento());

        TipoPagamento putTipoPagamento = tipoPagamentoService.saveTipoPagamento(tipoPagamento);

        return ResponseHandler.generateResponse("Tipo de pagamento atulizado com sucesso!", HttpStatus.OK, putTipoPagamento);
    }
}
