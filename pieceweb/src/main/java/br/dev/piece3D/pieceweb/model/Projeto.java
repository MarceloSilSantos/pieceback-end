package br.dev.piece3D.pieceweb.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.dev.piece3D.pieceweb.enums.FollowUp;
import br.dev.piece3D.pieceweb.enums.Material;
import br.dev.piece3D.pieceweb.enums.StatusProjeto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Projeto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private float largura;

	private float comprimento;

	private float altura;

	private String descricao;

	private String caminhoArquivo;

	private LocalDate dataFinalizacao;

	private String imagem;

	@Enumerated(EnumType.STRING)
	private Material material;

	@Enumerated(EnumType.STRING)
	private FollowUp followup;

	@Enumerated(EnumType.STRING)
	private StatusProjeto statusprojeto;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "projeto", fetch = FetchType.LAZY)
	private List<Orcamento> orcamentos;
	
	

	public List<Orcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getLargura() {
		return largura;
	}

	public void setLargura(float largura) {
		this.largura = largura;
	}

	public float getComprimento() {
		return comprimento;
	}

	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}

	public LocalDate getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(LocalDate dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public FollowUp getFollowup() {
		return followup;
	}

	public void setFollowup(FollowUp followup) {
		this.followup = followup;
	}

	public StatusProjeto getStatusprojeto() {
		return statusprojeto;
	}

	public void setStatusprojeto(StatusProjeto statusprojeto) {
		this.statusprojeto = statusprojeto;
	}
	
	
	
	
	

}
	