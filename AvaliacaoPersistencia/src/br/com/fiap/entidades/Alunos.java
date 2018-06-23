package br.com.fiap.entidades;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

public class Alunos {
	
	private int idAlunos;
	private String nome;
	private String email;
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="alunos")
	private List<Cursos> cursos;
	

	public int getIdAlunos() {
		return idAlunos;
	}
	public void setIdAlunos(int idAlunos) {
		this.idAlunos = idAlunos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Cursos> getCursos() {
		return cursos;
	}
	public void setCursos(List<Cursos> cursos) {
		this.cursos = cursos;
	}
	

}
