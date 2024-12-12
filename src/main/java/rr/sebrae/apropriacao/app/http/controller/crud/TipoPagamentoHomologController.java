package rr.sebrae.apropriacao.app.http.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.tipopagamento.dto.TipoPagamentoDTO;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.tipopagamento.entity.TipoPagamento;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.tipopagamento.service.TipoPagamentoService;
import rr.sebrae.apropriacao.app.exceptions.http.ResourceNotFoundException;
import rr.sebrae.apropriacao.app.http.responses.ResponseHandler;

import java.util.List;
import java.util.Optional;


@Profile("dev")
@RequestMapping("/rest")
@RestController
public class TipoPagamentoHomologController {

    @Autowired
    TipoPagamentoService tipoPagamentoService;

    @GetMapping("/tipopagamento")
    public ResponseEntity<Object> allTipoPagamento() {
        List<TipoPagamento> allTipoPagamento = tipoPagamentoService.findAllTipoPagamento();
        return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, allTipoPagamento);
    }

    @GetMapping("/tipopagamento/{id}")
    public ResponseEntity<Object> findTipoPagamentoById(@PathVariable int id) {
        Optional<TipoPagamento> tipoPagamento = tipoPagamentoService.findTipoPagamentoById(id);
        return tipoPagamento.map(tp -> ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, tp))
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado para id " + id));
    }

    @PostMapping("/tipopagamento")
    public ResponseEntity<Object> createTipoPagamento(@RequestBody TipoPagamentoDTO tipoPagamentoDTO) {
        TipoPagamento tipoPagamento = new TipoPagamento();
        tipoPagamento.setNomeTipoPagamento(tipoPagamentoDTO.nomeTipoPagamento());

        // Não passamos o ID manualmente, pois o banco irá gerar.
        TipoPagamento savedTipoPagamento = tipoPagamentoService.saveTipoPagamento(tipoPagamento);

        return ResponseHandler.generateResponse("Tipo de pagamento criado com sucesso!", HttpStatus.CREATED, savedTipoPagamento);
    }



    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

}

