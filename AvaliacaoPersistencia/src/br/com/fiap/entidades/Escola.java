package br.com.fiap.entidades;

import java.util.List;

import javax.persistence.OneToMany;

public class Escola {
	
	private int idEscola;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	
	@OneToMany(mappedBy = "escola")
	private List<Cursos> listaCursos;
	
	
	public int getIdEscola() {
		return idEscola;
	}
	public void setIdEscola(int idEscola) {
		this.idEscola = idEscola;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Cursos> getListaCursos() {
		return listaCursos;
	}
	public void setListaCursos(List<Cursos> listaCursos) {
		this.listaCursos = listaCursos;
	}
	
	

}
