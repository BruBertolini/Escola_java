package br.com.fiap.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.entidades.Aluno;
import br.com.fiap.helper.AlunosHelper;

public class AlunoApp {

	private static final String NOME_EM = "jpaExec";

	public static void incluirAluno() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_EM);
		EntityManager em = emf.createEntityManager();
		AlunosHelper helper = new AlunosHelper(em);

		Aluno aluno = new Aluno();
		aluno.setNome(JOptionPane.showInputDialog("Nome do Aluno:"));
		aluno.setEmail(JOptionPane.showInputDialog("E-mail do Aluno: "));
		

		try {
			helper.salvar(aluno);
			JOptionPane.showMessageDialog(null, "Aluno registrado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static Aluno escolherAluno() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_EM);
		EntityManager em = emf.createEntityManager();
		AlunosHelper helper = new AlunosHelper(em);
		
		List<Aluno> listaAlunos =  helper.listarAlunos();
		
		Object[] choices = new Object[listaAlunos.size()];
		
		int contador = 0;
		for (Aluno aluno : listaAlunos) {
			choices[contador] = aluno;
			contador++;
		}

		Aluno input = (Aluno) JOptionPane.showInputDialog(null, "Alunos", "Escolha um aluno:",
				JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

		return input;
	}
}
