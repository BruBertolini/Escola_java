package br.com.fiap.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idAlunos", unique = true, nullable = false)
	private int idAlunos;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "EMAIL")
	private String email;
	
	@OneToMany(mappedBy="aluno")
	private List<Nota> listaNotas;


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
	public List<Nota> getListaNotas() {
		return listaNotas;
	}
	public void setListaNotas(List<Nota> listaNotas) {
		this.listaNotas = listaNotas;
	}

	@Override
	public String toString() {
		return this.nome;
	}


}
