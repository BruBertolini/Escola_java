package br.com.fiap.entidades;

public class Alunos {
	
	private int idAlunos;
	private String nome;
	private String email;
	private Cursos curso;
	
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
	public Cursos getCurso() {
		return curso;
	}
	public void setCurso(Cursos curso) {
		this.curso = curso;
	}
	
	

}
