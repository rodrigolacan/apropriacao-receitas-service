package rr.sebrae.apropriacao.app.database.intranet2013.table.gusuarios.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "GUsuarios")
public class GUsuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDUsuario")
    private Integer idUsuario;

    @Column(name = "IDUsuarioAntigo")
    private Integer idUsuarioAntigo;

    @Column(name = "sc_activation_code", length = 32)
    private String activationCode;

    @Column(name = "sc_priv_admin", length = 1)
    private String privAdmin;

    @Column(name = "login", length = 25, nullable = false)
    private String login;

    @Column(name = "senha", length = 32)
    private String senha;

    @Column(name = "IDDominio")
    private Integer idDominio;

    @Column(name = "IDColigada")
    private Integer idColigada;

    @Column(name = "nomeR", length = 25)
    private String nomeR;

    @Column(name = "nomeC", length = 50)
    private String nomeC;

    @Column(name = "chapaRM", length = 8)
    private String chapaRM;

    @Column(name = "sexo", length = 1)
    private String sexo;

    @Column(name = "dtNascimento")
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;

    @Column(name = "exibeAniversario", length = 1, columnDefinition = "DEFAULT 'S'")
    private String exibeAniversario;

    @Column(name = "habCEP", length = 10)
    private String habCEP;

    @Column(name = "habLogradouro", length = 150)
    private String habLogradouro;

    @Column(name = "habNumero", length = 7)
    private String habNumero;

    @Column(name = "habComplemento", length = 50)
    private String habComplemento;

    @Column(name = "habBairro", length = 36)
    private String habBairro;

    @Column(name = "habCidade", length = 36)
    private String habCidade;

    @Column(name = "habUF", length = 2)
    private String habUF;

    @Column(name = "foneResid", length = 15)
    private String foneResid;

    @Column(name = "foneCelular", length = 15)
    private String foneCelular;

    @Column(name = "foneRamal", length = 14)
    private String foneRamal;

    @Column(name = "foneDireto", length = 15)
    private String foneDireto;

    @Column(name = "corpDtInicio")
    @Temporal(TemporalType.DATE)
    private Date corpDtInicio;

    @Column(name = "corpAtivo", length = 1, columnDefinition = "DEFAULT 'S'")
    private String corpAtivo;

    @Column(name = "corpEmail", length = 80)
    private String corpEmail;

    @Column(name = "corpVinculo", length = 10)
    private String corpVinculo;

    @Column(name = "docCPF", length = 14)
    private String docCPF;

    @Column(name = "IDCargo")
    private Integer idCargo;

    @Column(name = "IDSetor")
    private Integer idSetor;

    @Lob
    @Column(name = "corpFotoPequena")
    private byte[] corpFotoPequena;

    @Lob
    @Column(name = "corpFotoMedia")
    private byte[] corpFotoMedia;

    @Lob
    @Column(name = "corpFotoAssinatura")
    private byte[] corpFotoAssinatura;

    @Column(name = "admUltAlteraData")
    @Temporal(TemporalType.DATE)
    private Date admUltAlteraData;

    @Column(name = "perfilFrase", length = 45)
    private String perfilFrase;

    @Column(name = "emailPessoal", length = 80)
    private String emailPessoal;

    @Column(name = "perfilConfigTema", length = 20)
    private String perfilConfigTema;

    @Column(name = "perfilConfigTipoBg", length = 1)
    private String perfilConfigTipoBg;

    @Column(name = "perfilConfigBgColor", length = 8)
    private String perfilConfigBgColor;

    @Column(name = "perfilConfigBgImagem", length = 100)
    private String perfilConfigBgImagem;

    @Column(name = "perfilConfigBgRepeat", length = 15)
    private String perfilConfigBgRepeat;

    @Column(name = "perfilConfigFonteFrase", length = 30)
    private String perfilConfigFonteFrase;

    @Column(name = "perfilConfigFonteSize", length = 5)
    private String perfilConfigFonteSize;

    @Column(name = "perfilConfigTransparencia", length = 5)
    private String perfilConfigTransparencia;

    @Column(name = "admAtualizacaoExpressa", length = 1, columnDefinition = "DEFAULT 'N'")
    private String admAtualizacaoExpressa;

    @Column(name = "IDTpSanguineo")
    private Integer idTpSanguineo;

    @Column(name = "foneContato", length = 15)
    private String foneContato;

    @Column(name = "foneContatoNome", length = 50)
    private String foneContatoNome;

    @Column(name = "pai", length = 50)
    private String pai;

    @Column(name = "mae", length = 50)
    private String mae;

    @Column(name = "contratoVigenteTCE")
    private Integer contratoVigenteTCE;

    @Column(name = "contratoVigenteInicio")
    @Temporal(TemporalType.DATE)
    private Date contratoVigenteInicio;

    @Column(name = "contratoVigenteTermino")
    @Temporal(TemporalType.DATE)
    private Date contratoVigenteTermino;

    @Column(name = "contratoAreaPgto", length = 7)
    private String contratoAreaPgto;

    @Column(name = "contratoAgente", length = 5)
    private String contratoAgente;

    @Column(name = "contratoTurno", length = 10)
    private String contratoTurno;

    @Column(name = "dtCadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    @Column(name = "IDQuemalterou")
    private Integer idQuemAlterou;

    @Column(name = "titularSuplente", length = 1)
    private String titularSuplente;

    @Column(name = "instituicao", length = 80)
    private String instituicao;

    @Column(name = "divulgarCelular", length = 1, columnDefinition = "DEFAULT 'S'")
    private String divulgarCelular;

    @Column(name = "admUGPLiberaChangeSetor", length = 1, columnDefinition = "DEFAULT 'N'")
    private String admUGPLiberaChangeSetor;

    @Column(name = "changeSetorTitulo", length = 50)
    private String changeSetorTitulo;

    @Column(name = "changeSetorAno", length = 4)
    private String changeSetorAno;

    @Column(name = "changeSetorUnidadeAtual", length = 25)
    private String changeSetorUnidadeAtual;

    @Column(name = "changeSetorDesejaMudar", length = 1, columnDefinition = "DEFAULT 'N'")
    private String changeSetorDesejaMudar;

    @Column(name = "changeSetorUnidadeDesejada", length = 25)
    private String changeSetorUnidadeDesejada;

    @Column(name = "changeSetorFormacaoHabilidades", columnDefinition = "varchar(max)")
    private String changeSetorFormacaoHabilidades;

    @Column(name = "IDCorpFuncaoGerencial")
    private Integer idCorpFuncaoGerencial;

    @Column(name = "termoUso_aceite", length = 1)
    private String termoUsoAceite;

    @Column(name = "termoUso_data")
    @Temporal(TemporalType.DATE)
    private Date termoUsoData;

    @Column(name = "CRM_pessoaCodParceiro")
    private Integer crmPessoaCodParceiro;

    @Column(name = "CRM_possuiWhatsApp", length = 1, columnDefinition = "DEFAULT 'S'")
    private String crmPossuiWhatsApp;

    @Column(name = "pinImpressora", length = 4)
    private String pinImpressora;

    @Column(name = "favCCProjeto", length = 10)
    private String favCCProjeto;

    @Column(name = "favCCAcao", length = 20)
    private String favCCAcao;

    @Column(name = "favCCUnidade", length = 25)
    private String favCCUnidade;

    @Column(name = "token", length = 255)
    private String token;

    // Getters e Setters
    // ...

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuarioAntigo() {
        return idUsuarioAntigo;
    }

    public void setIdUsuarioAntigo(Integer idUsuarioAntigo) {
        this.idUsuarioAntigo = idUsuarioAntigo;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getPrivAdmin() {
        return privAdmin;
    }

    public void setPrivAdmin(String privAdmin) {
        this.privAdmin = privAdmin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getIdDominio() {
        return idDominio;
    }

    public void setIdDominio(Integer idDominio) {
        this.idDominio = idDominio;
    }

    public Integer getIdColigada() {
        return idColigada;
    }

    public void setIdColigada(Integer idColigada) {
        this.idColigada = idColigada;
    }

    public String getNomeR() {
        return nomeR;
    }

    public void setNomeR(String nomeR) {
        this.nomeR = nomeR;
    }

    public String getNomeC() {
        return nomeC;
    }

    public void setNomeC(String nomeC) {
        this.nomeC = nomeC;
    }

    public String getChapaRM() {
        return chapaRM;
    }

    public void setChapaRM(String chapaRM) {
        this.chapaRM = chapaRM;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getExibeAniversario() {
        return exibeAniversario;
    }

    public void setExibeAniversario(String exibeAniversario) {
        this.exibeAniversario = exibeAniversario;
    }

    public String getHabCEP() {
        return habCEP;
    }

    public void setHabCEP(String habCEP) {
        this.habCEP = habCEP;
    }

    public String getHabLogradouro() {
        return habLogradouro;
    }

    public void setHabLogradouro(String habLogradouro) {
        this.habLogradouro = habLogradouro;
    }

    public String getHabNumero() {
        return habNumero;
    }

    public void setHabNumero(String habNumero) {
        this.habNumero = habNumero;
    }

    public String getHabComplemento() {
        return habComplemento;
    }

    public void setHabComplemento(String habComplemento) {
        this.habComplemento = habComplemento;
    }

    public String getHabBairro() {
        return habBairro;
    }

    public void setHabBairro(String habBairro) {
        this.habBairro = habBairro;
    }

    public String getHabCidade() {
        return habCidade;
    }

    public void setHabCidade(String habCidade) {
        this.habCidade = habCidade;
    }

    public String getHabUF() {
        return habUF;
    }

    public void setHabUF(String habUF) {
        this.habUF = habUF;
    }

    public String getFoneResid() {
        return foneResid;
    }

    public void setFoneResid(String foneResid) {
        this.foneResid = foneResid;
    }

    public String getFoneCelular() {
        return foneCelular;
    }

    public void setFoneCelular(String foneCelular) {
        this.foneCelular = foneCelular;
    }

    public String getFoneRamal() {
        return foneRamal;
    }

    public void setFoneRamal(String foneRamal) {
        this.foneRamal = foneRamal;
    }

    public String getFoneDireto() {
        return foneDireto;
    }

    public void setFoneDireto(String foneDireto) {
        this.foneDireto = foneDireto;
    }

    public Date getCorpDtInicio() {
        return corpDtInicio;
    }

    public void setCorpDtInicio(Date corpDtInicio) {
        this.corpDtInicio = corpDtInicio;
    }

    public String getCorpAtivo() {
        return corpAtivo;
    }

    public void setCorpAtivo(String corpAtivo) {
        this.corpAtivo = corpAtivo;
    }

    public String getCorpEmail() {
        return corpEmail;
    }

    public void setCorpEmail(String corpEmail) {
        this.corpEmail = corpEmail;
    }

    public String getCorpVinculo() {
        return corpVinculo;
    }

    public void setCorpVinculo(String corpVinculo) {
        this.corpVinculo = corpVinculo;
    }

    public String getDocCPF() {
        return docCPF;
    }

    public void setDocCPF(String docCPF) {
        this.docCPF = docCPF;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public byte[] getCorpFotoPequena() {
        return corpFotoPequena;
    }

    public void setCorpFotoPequena(byte[] corpFotoPequena) {
        this.corpFotoPequena = corpFotoPequena;
    }

    public byte[] getCorpFotoMedia() {
        return corpFotoMedia;
    }

    public void setCorpFotoMedia(byte[] corpFotoMedia) {
        this.corpFotoMedia = corpFotoMedia;
    }

    public byte[] getCorpFotoAssinatura() {
        return corpFotoAssinatura;
    }

    public void setCorpFotoAssinatura(byte[] corpFotoAssinatura) {
        this.corpFotoAssinatura = corpFotoAssinatura;
    }

    public Date getAdmUltAlteraData() {
        return admUltAlteraData;
    }

    public void setAdmUltAlteraData(Date admUltAlteraData) {
        this.admUltAlteraData = admUltAlteraData;
    }

    public String getPerfilFrase() {
        return perfilFrase;
    }

    public void setPerfilFrase(String perfilFrase) {
        this.perfilFrase = perfilFrase;
    }

    public String getEmailPessoal() {
        return emailPessoal;
    }

    public void setEmailPessoal(String emailPessoal) {
        this.emailPessoal = emailPessoal;
    }

    public String getPerfilConfigTema() {
        return perfilConfigTema;
    }

    public void setPerfilConfigTema(String perfilConfigTema) {
        this.perfilConfigTema = perfilConfigTema;
    }

    public String getPerfilConfigTipoBg() {
        return perfilConfigTipoBg;
    }

    public void setPerfilConfigTipoBg(String perfilConfigTipoBg) {
        this.perfilConfigTipoBg = perfilConfigTipoBg;
    }

    public String getPerfilConfigBgColor() {
        return perfilConfigBgColor;
    }

    public void setPerfilConfigBgColor(String perfilConfigBgColor) {
        this.perfilConfigBgColor = perfilConfigBgColor;
    }

    public String getPerfilConfigBgImagem() {
        return perfilConfigBgImagem;
    }

    public void setPerfilConfigBgImagem(String perfilConfigBgImagem) {
        this.perfilConfigBgImagem = perfilConfigBgImagem;
    }

    public String getPerfilConfigBgRepeat() {
        return perfilConfigBgRepeat;
    }

    public void setPerfilConfigBgRepeat(String perfilConfigBgRepeat) {
        this.perfilConfigBgRepeat = perfilConfigBgRepeat;
    }

    public String getPerfilConfigFonteFrase() {
        return perfilConfigFonteFrase;
    }

    public void setPerfilConfigFonteFrase(String perfilConfigFonteFrase) {
        this.perfilConfigFonteFrase = perfilConfigFonteFrase;
    }

    public String getPerfilConfigFonteSize() {
        return perfilConfigFonteSize;
    }

    public void setPerfilConfigFonteSize(String perfilConfigFonteSize) {
        this.perfilConfigFonteSize = perfilConfigFonteSize;
    }

    public String getPerfilConfigTransparencia() {
        return perfilConfigTransparencia;
    }

    public void setPerfilConfigTransparencia(String perfilConfigTransparencia) {
        this.perfilConfigTransparencia = perfilConfigTransparencia;
    }

    public String getAdmAtualizacaoExpressa() {
        return admAtualizacaoExpressa;
    }

    public void setAdmAtualizacaoExpressa(String admAtualizacaoExpressa) {
        this.admAtualizacaoExpressa = admAtualizacaoExpressa;
    }

    public Integer getIdTpSanguineo() {
        return idTpSanguineo;
    }

    public void setIdTpSanguineo(Integer idTpSanguineo) {
        this.idTpSanguineo = idTpSanguineo;
    }

    public String getFoneContato() {
        return foneContato;
    }

    public void setFoneContato(String foneContato) {
        this.foneContato = foneContato;
    }

    public String getFoneContatoNome() {
        return foneContatoNome;
    }

    public void setFoneContatoNome(String foneContatoNome) {
        this.foneContatoNome = foneContatoNome;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public Integer getContratoVigenteTCE() {
        return contratoVigenteTCE;
    }

    public void setContratoVigenteTCE(Integer contratoVigenteTCE) {
        this.contratoVigenteTCE = contratoVigenteTCE;
    }

    public Date getContratoVigenteInicio() {
        return contratoVigenteInicio;
    }

    public void setContratoVigenteInicio(Date contratoVigenteInicio) {
        this.contratoVigenteInicio = contratoVigenteInicio;
    }

    public Date getContratoVigenteTermino() {
        return contratoVigenteTermino;
    }

    public void setContratoVigenteTermino(Date contratoVigenteTermino) {
        this.contratoVigenteTermino = contratoVigenteTermino;
    }

    public String getContratoAreaPgto() {
        return contratoAreaPgto;
    }

    public void setContratoAreaPgto(String contratoAreaPgto) {
        this.contratoAreaPgto = contratoAreaPgto;
    }

    public String getContratoAgente() {
        return contratoAgente;
    }

    public void setContratoAgente(String contratoAgente) {
        this.contratoAgente = contratoAgente;
    }

    public String getContratoTurno() {
        return contratoTurno;
    }

    public void setContratoTurno(String contratoTurno) {
        this.contratoTurno = contratoTurno;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Integer getIdQuemAlterou() {
        return idQuemAlterou;
    }

    public void setIdQuemAlterou(Integer idQuemAlterou) {
        this.idQuemAlterou = idQuemAlterou;
    }

    public String getTitularSuplente() {
        return titularSuplente;
    }

    public void setTitularSuplente(String titularSuplente) {
        this.titularSuplente = titularSuplente;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getDivulgarCelular() {
        return divulgarCelular;
    }

    public void setDivulgarCelular(String divulgarCelular) {
        this.divulgarCelular = divulgarCelular;
    }

    public String getAdmUGPLiberaChangeSetor() {
        return admUGPLiberaChangeSetor;
    }

    public void setAdmUGPLiberaChangeSetor(String admUGPLiberaChangeSetor) {
        this.admUGPLiberaChangeSetor = admUGPLiberaChangeSetor;
    }

    public String getChangeSetorTitulo() {
        return changeSetorTitulo;
    }

    public void setChangeSetorTitulo(String changeSetorTitulo) {
        this.changeSetorTitulo = changeSetorTitulo;
    }

    public String getChangeSetorAno() {
        return changeSetorAno;
    }

    public void setChangeSetorAno(String changeSetorAno) {
        this.changeSetorAno = changeSetorAno;
    }

    public String getChangeSetorUnidadeAtual() {
        return changeSetorUnidadeAtual;
    }

    public void setChangeSetorUnidadeAtual(String changeSetorUnidadeAtual) {
        this.changeSetorUnidadeAtual = changeSetorUnidadeAtual;
    }

    public String getChangeSetorDesejaMudar() {
        return changeSetorDesejaMudar;
    }

    public void setChangeSetorDesejaMudar(String changeSetorDesejaMudar) {
        this.changeSetorDesejaMudar = changeSetorDesejaMudar;
    }

    public String getChangeSetorUnidadeDesejada() {
        return changeSetorUnidadeDesejada;
    }

    public void setChangeSetorUnidadeDesejada(String changeSetorUnidadeDesejada) {
        this.changeSetorUnidadeDesejada = changeSetorUnidadeDesejada;
    }

    public String getChangeSetorFormacaoHabilidades() {
        return changeSetorFormacaoHabilidades;
    }

    public void setChangeSetorFormacaoHabilidades(String changeSetorFormacaoHabilidades) {
        this.changeSetorFormacaoHabilidades = changeSetorFormacaoHabilidades;
    }

    public Integer getIdCorpFuncaoGerencial() {
        return idCorpFuncaoGerencial;
    }

    public void setIdCorpFuncaoGerencial(Integer idCorpFuncaoGerencial) {
        this.idCorpFuncaoGerencial = idCorpFuncaoGerencial;
    }

    public String getTermoUsoAceite() {
        return termoUsoAceite;
    }

    public void setTermoUsoAceite(String termoUsoAceite) {
        this.termoUsoAceite = termoUsoAceite;
    }

    public Date getTermoUsoData() {
        return termoUsoData;
    }

    public void setTermoUsoData(Date termoUsoData) {
        this.termoUsoData = termoUsoData;
    }

    public Integer getCrmPessoaCodParceiro() {
        return crmPessoaCodParceiro;
    }

    public void setCrmPessoaCodParceiro(Integer crmPessoaCodParceiro) {
        this.crmPessoaCodParceiro = crmPessoaCodParceiro;
    }

    public String getCrmPossuiWhatsApp() {
        return crmPossuiWhatsApp;
    }

    public void setCrmPossuiWhatsApp(String crmPossuiWhatsApp) {
        this.crmPossuiWhatsApp = crmPossuiWhatsApp;
    }

    public String getPinImpressora() {
        return pinImpressora;
    }

    public void setPinImpressora(String pinImpressora) {
        this.pinImpressora = pinImpressora;
    }

    public String getFavCCProjeto() {
        return favCCProjeto;
    }

    public void setFavCCProjeto(String favCCProjeto) {
        this.favCCProjeto = favCCProjeto;
    }

    public String getFavCCAcao() {
        return favCCAcao;
    }

    public void setFavCCAcao(String favCCAcao) {
        this.favCCAcao = favCCAcao;
    }

    public String getFavCCUnidade() {
        return favCCUnidade;
    }

    public void setFavCCUnidade(String favCCUnidade) {
        this.favCCUnidade = favCCUnidade;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
