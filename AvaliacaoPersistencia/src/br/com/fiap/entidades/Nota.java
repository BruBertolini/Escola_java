package br.com.fiap.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NOTA")
public class Nota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idNota", unique = true, nullable = false)
	private int idNota;
	
	@Column(name = "NOME")
	private double nota;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALUNOS_ID")
	private Aluno aluno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CURSOS_ID")
	private Curso curso;
	
	
	public int getIdNota() {
		return idNota;
	}
	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	

}
