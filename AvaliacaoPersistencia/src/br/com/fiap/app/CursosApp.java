package br.com.fiap.app;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.entidades.Aluno;
import br.com.fiap.entidades.Curso;
import br.com.fiap.entidades.Escola;
import br.com.fiap.helper.CursosHelper;

public class CursosApp {

	private static final String NOME_EM = "jpaExec";

	public static void main(String[] args) {

		escolherCurso(1);

	}

	public static void incluirCurso(Escola escola) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_EM);
		EntityManager em = emf.createEntityManager();
		CursosHelper helper = new CursosHelper(em);

		Curso curso = new Curso();
		curso.setNome(JOptionPane.showInputDialog("Nome do Curso:"));
		curso.setDescricao(JOptionPane.showInputDialog("Descricao do curso: "));

		Calendar inicio = Calendar.getInstance();
		Calendar fim = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyyy");

		try {
			inicio.setTime(sdf.parse(JOptionPane.showInputDialog("Data de Inicio (dd/mm/aaaa): ")));
			fim.setTime(sdf.parse(JOptionPane.showInputDialog("Data de Termino (dd/mm/aaaa): ")));
		} catch (Exception e) {
			inicio = Calendar.getInstance();
			fim = Calendar.getInstance();
		}
		curso.setInicio(inicio);
		curso.setTermino(fim);
		
		
		curso.setPeriodo(JOptionPane.showInputDialog("Periodo do Curso:"));

		curso.setEscola(escola);

		try {
			helper.salvar(curso);
			JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void listaCursos(int idEscola) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_EM);
		EntityManager em = emf.createEntityManager();
		CursosHelper helper = new CursosHelper(em);

		for (Curso curso : helper.listarCursos(idEscola)) {
			System.out.println("Id: " + curso.getIdCursos());
			System.out.println("Nome: " + curso.getNome());
			System.out.println("Descrição: " + curso.getDescricao());

			System.out.println("-------------------------------------");
		}
	}

	public static void listarAlunos(int idCurso) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_EM);
		EntityManager em = emf.createEntityManager();
		CursosHelper helper = new CursosHelper(em);

		for (Aluno aluno : helper.listaAlunos(idCurso)) {
			System.out.println("Id: " + aluno.getIdAlunos());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Email: " + aluno.getEmail());
			System.out.println("-------------------------------------");
		}
	}

	public static Curso escolherCurso(int idEscola) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_EM);
		EntityManager em = emf.createEntityManager();
		CursosHelper helper = new CursosHelper(em);

		List<Curso> listaCursos = helper.listarCursos(idEscola);

		Object[] choices = new Object[listaCursos.size()];

		int contador = 0;
		for (Curso cursos : listaCursos) {
			choices[contador] = cursos;
			contador++;
		}

		Curso input = (Curso) JOptionPane.showInputDialog(null, "Escola", "Escolha um curso:",
				JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

		return input;
	}
}
