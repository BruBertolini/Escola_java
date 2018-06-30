package br.com.fiap.app;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.entidades.Aluno;
import br.com.fiap.entidades.Curso;
import br.com.fiap.entidades.Escola;
import br.com.fiap.entidades.Nota;
import br.com.fiap.helper.AlunosHelper;
import br.com.fiap.helper.NotaHelper;

public class NotaApp {
	
	private static final String NOME_EM = "jpaExec";
	

	public static void incluirNota(Aluno aluno, Curso curso) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_EM);
		EntityManager em = emf.createEntityManager();
		NotaHelper helper = new NotaHelper(em);
		
		Nota nota  = new Nota();
		nota.setNota(Double.parseDouble(JOptionPane.showInputDialog("Qual a nota?")));
		nota.setAluno(aluno);
		nota.setCurso(curso);
		
		try {
			helper.salvar(nota);
			JOptionPane.showMessageDialog(null, "Nota registrada!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
