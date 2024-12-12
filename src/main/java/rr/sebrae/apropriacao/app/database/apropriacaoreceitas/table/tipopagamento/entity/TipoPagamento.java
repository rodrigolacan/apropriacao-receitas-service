package rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.tipopagamento.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.Profile;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.viarecibo.entity.ViaRecibo;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Profile("prod")
@Table(name = "tipo_pagamento")
public class TipoPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "tipo_pagamento_id_gen", sequenceName = "tipo_pagamento_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome_tipo_pagamento", nullable = false, length = Integer.MAX_VALUE)
    private String nomeTipoPagamento;

    @OneToMany(mappedBy = "tipoPagamento")
    private Set<ViaRecibo> viaRecibos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeTipoPagamento() {
        return nomeTipoPagamento;
    }

    public void setNomeTipoPagamento(String nomeTipoPagamento) {
        this.nomeTipoPagamento = nomeTipoPagamento;
    }

    public Set<ViaRecibo> getViaRecibos() {
        return viaRecibos;
    }

    public void setViaRecibos(Set<ViaRecibo> viaRecibos) {
        this.viaRecibos = viaRecibos;
    }

}