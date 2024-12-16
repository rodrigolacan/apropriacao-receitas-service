package rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.tipopagamento.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.context.annotation.Profile;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table.viarecibo.entity.ViaRecibo;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Profile("dev")
@Table(name = "tipo_pagamento")
@EntityListeners(AuditingEntityListener.class)
public class TipoPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "tipo_pagamento_id_gen", sequenceName = "tipo_pagamento_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome_tipo_pagamento", nullable = false, length = Integer.MAX_VALUE)
    private String nomeTipoPagamento;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "tipoPagamento")
    @JsonIgnore
    private Set<ViaRecibo> viaRecibos = new LinkedHashSet<>();

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}