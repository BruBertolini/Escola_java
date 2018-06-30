package br.com.fiap.app;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entidades.Alunos;
import br.com.fiap.entidades.Cursos;
import br.com.fiap.entidades.Escola;
import br.com.fiap.entidades.Nota;
import br.com.fiap.helper.AlunosHelper;
import br.com.fiap.helper.NotaHelper;

public class NotaApp {
	
	private static final String NOME_EM = "jpaExec";
	
	public static void main(String[] args) {
		incluirNota();
	}
	
	private static void incluirNota() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_EM);
		EntityManager em = emf.createEntityManager();
		NotaHelper helper = new NotaHelper(em);
		
		Alunos aluno = new Alunos();
		aluno.setIdAlunos(1);
		aluno.setNome("Bruna Bertolini");
		aluno.setEmail("email@email.com");

		Cursos curso = new Cursos();
		curso.setIdCursos(7);
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
		
		Nota nota = new Nota();
		nota.setAluno(aluno);
		nota.setCurso(curso);
		nota.setNota(10);
		

		try {
			helper.salvar(nota);
			System.out.println("Nota cadastrada");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
