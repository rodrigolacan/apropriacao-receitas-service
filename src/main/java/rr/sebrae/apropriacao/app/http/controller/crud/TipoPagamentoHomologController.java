package rr.sebrae.apropriacao.app.http.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.tipopagamento.entity.TipoPagamento;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.tipopagamento.service.TipoPagamentoService;

import java.util.List;


@Profile("dev")
@RequestMapping("/rest")
@RestController
public class TipoPagamentoHomologController {

    @Autowired
    TipoPagamentoService tipoPagamentoService;

    @GetMapping("/tipopagamento")
    public List<TipoPagamento> AlltipoPagamento() {
       return tipoPagamentoService.findAllTipoPagamento();
    }


}

