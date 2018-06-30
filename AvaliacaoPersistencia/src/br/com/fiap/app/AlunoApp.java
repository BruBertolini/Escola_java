package br.com.fiap.app;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entidades.Alunos;
import br.com.fiap.entidades.Cursos;
import br.com.fiap.entidades.Escola;
import br.com.fiap.helper.AlunosHelper;
import br.com.fiap.helper.CursosHelper;

public class AlunoApp {

	private static final String NOME_EM = "jpaExec";

	public static void main(String[] args) {
		incluirAluno();
	}

	private static void incluirAluno() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_EM);
		EntityManager em = emf.createEntityManager();
		AlunosHelper helper = new AlunosHelper(em);

		Alunos aluno = new Alunos();
		aluno.setNome("Bruna Bertolini");
		aluno.setEmail("email@email.com");
		

		try {
			helper.salvar(aluno);
			System.out.println("Aluno cadastrado");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
