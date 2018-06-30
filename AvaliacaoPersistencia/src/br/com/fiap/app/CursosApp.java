package br.com.fiap.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.entidades.Alunos;
import br.com.fiap.entidades.Cursos;
import br.com.fiap.entidades.Escola;
import br.com.fiap.helper.CursosHelper;

public class CursosApp {

	private static final String NOME_EM = "jpaExec";

	public static void main(String[] args) {
		
		incluirCurso();

	}

	private static void incluirCurso() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_EM);
		EntityManager em = emf.createEntityManager();
		CursosHelper helper = new CursosHelper(em);

		Cursos curso = new Cursos();
		curso.setDescricao("Teste");
		curso.setInicio(new Date());
		curso.setTermino(new Date());
		curso.setNome("Nome Curso");
		curso.setPeriodo("1");
				
		Escola escola = new Escola();
		escola.setNome("Nome");
		escola.setEndereco("endereco");
		escola.setTelefone("121567");
		escola.setEmail("email@email.com");
		escola.setIdEscola(1);
		
		curso.setEscola(escola);
		
		try {
			helper.salvar(curso);
			System.out.println("Curso cadastrado");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void listaCursos() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_EM);
		EntityManager em = emf.createEntityManager();
		CursosHelper helper = new CursosHelper(em);

		for (Cursos curso : helper.listarCursos()) {
			System.out.println("Id: " + curso.getIdCursos());
			System.out.println("Nome: " + curso.getNome());
			System.out.println("Descrição: " + curso.getDescricao());
			
			System.out.println("-------------------------------------");
		}
	}

	private static void listarAlunos(int idCurso) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_EM);
		EntityManager em = emf.createEntityManager();
		CursosHelper helper = new CursosHelper(em);

		for (Alunos aluno : helper.listaAlunos(idCurso)) {
			System.out.println("Id: " + aluno.getIdAlunos());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Email: " + aluno.getEmail());
			System.out.println("-------------------------------------");
		}
	}
}
