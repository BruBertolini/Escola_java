package br.com.fiap.entidades;

import java.util.Date;

public class Cursos {
	
	private int idCursos;
	private String nome;
	private String descricao;
	private Escola escola;
	private Alunos aluno;
	private Date inicio;
	private Date termino;
	private String periodo;
	
	public int getIdCursos() {
		return idCursos;
	}
	public void setIdCursos(int idCursos) {
		this.idCursos = idCursos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Escola getEscola() {
		return escola;
	}
	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	public Alunos getAluno() {
		return aluno;
	}
	public void setAluno(Alunos aluno) {
		this.aluno = aluno;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getTermino() {
		return termino;
	}
	public void setTermino(Date termino) {
		this.termino = termino;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	

}
