package br.com.fiap.entidades;

public class Nota {
	
	private int idNota;
	private double nota;
	private Alunos aluno;
	private Cursos curso;
	
	
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
	public Alunos getAluno() {
		return aluno;
	}
	public void setAluno(Alunos aluno) {
		this.aluno = aluno;
	}
	public Cursos getCurso() {
		return curso;
	}
	public void setCurso(Cursos curso) {
		this.curso = curso;
	}
	
	
	

}
