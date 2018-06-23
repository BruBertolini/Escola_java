package br.com.fiap.entidades;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cursos")
public class Cursos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idCursos", unique = true, nullable = false)
	private int idCursos;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "DESCRICAO")
	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ESCOLA_ID")
	private Escola escola;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "CURSO_ALUNO", catalog = "dbescola", joinColumns = {
			@JoinColumn(name = "idCursos", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "idAluno", nullable = false, updatable = false) })
	private Alunos alunos;

	@Column(name = "INICIO")
	@Temporal(TemporalType.DATE)
	private Date inicio;

	@Column(name = "TERMINO")
	@Temporal(TemporalType.DATE)
	private Date termino;

	@Column(name = "PERIODO")
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
		return alunos;
	}

	public void setAluno(Alunos alunos) {
		this.alunos = alunos;
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
