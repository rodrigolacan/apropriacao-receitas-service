package rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.viarecibo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.context.annotation.Profile;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table.tipopagamento.entity.TipoPagamento;

import java.time.LocalDateTime;

@Entity
@Profile("prod")
@Table(name = "via_recibo")
@EntityListeners(AuditingEntityListener.class)
public class ViaRecibo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('via_recibo_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome_cliente", nullable = false, length = Integer.MAX_VALUE)
    private String nomeCliente;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @ColumnDefault("nextval('via_recibo_tipo_pagamento_seq')")
    @JoinColumn(name = "tipo_pagamento", nullable = false)
    private TipoPagamento tipoPagamento;

    @Column(name = "servico_faturado", nullable = false, length = Integer.MAX_VALUE)
    private String servicoFaturado;

    @Column(name = "unidade", nullable = false, length = Integer.MAX_VALUE)
    private String unidade;

    @Column(name = "dotacao_orcamentaria", nullable = false, length = Integer.MAX_VALUE)
    private String dotacaoOrcamentaria;

    @Column(name = "data_final_prestacao_servico", nullable = false, length = Integer.MAX_VALUE)
    private String dataFinalPrestacaoServico;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getServicoFaturado() {
        return servicoFaturado;
    }

    public void setServicoFaturado(String servicoFaturado) {
        this.servicoFaturado = servicoFaturado;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getDotacaoOrcamentaria() {
        return dotacaoOrcamentaria;
    }

    public void setDotacaoOrcamentaria(String dotacaoOrcamentaria) {
        this.dotacaoOrcamentaria = dotacaoOrcamentaria;
    }

    public String getDataFinalPrestacaoServico() {
        return dataFinalPrestacaoServico;
    }

    public void setDataFinalPrestacaoServico(String dataFinalPrestacaoServico) {
        this.dataFinalPrestacaoServico = dataFinalPrestacaoServico;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

}