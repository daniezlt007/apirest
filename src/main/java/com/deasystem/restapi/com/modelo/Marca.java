package com.deasystem.restapi.com.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="marca")
public class Marca implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long marcaId;
	@Column(unique = true)
	private String nome;
	@OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
	private List<Patrimonio> patrimonios;
	
	public Marca() {
		
	}

	public Marca(Long marcaId, String nome, List<Patrimonio> patrimonios) {
		super();
		this.marcaId = marcaId;
		this.nome = nome;
		this.patrimonios = patrimonios;
	}

	public Long getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(Long marcaId) {
		this.marcaId = marcaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Patrimonio> getPatrimonios() {
		return patrimonios;
	}

	public void setPatrimonios(List<Patrimonio> patrimonios) {
		this.patrimonios = patrimonios;
	}
	
}
