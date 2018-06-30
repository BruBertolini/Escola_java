package br.com.fiap.app;

import javax.swing.JOptionPane;

import br.com.fiap.entidades.Aluno;
import br.com.fiap.entidades.Curso;
import br.com.fiap.entidades.Escola;

public class MainApp {

	public static void main(String[] args) {

		String[] choices = new String[5];
		choices[0] = "INCLUIR ESCOLA";
		choices[1] = "INCLUIR CURSO";
		choices[2] = "INCLUIR ALUNO";
		choices[3] = "INCLUIR NOTA";
		choices[4] = "SAIR";

		String opcao;
		do {
			opcao = (String) JOptionPane.showInputDialog(null, "MENU", "Escolha uma opção:",
					JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

			if (opcao.equals(choices[0])) {
				EscolaApp.incluirEscola();
			} else if (opcao.equals(choices[1])) {
				cadastrarCurso();
			} else if (opcao.equals(choices[2])) {
				AlunoApp.incluirAluno();
			} else if (opcao.equals(choices[3])) {
				cadastroNota();
			}

		} while (!opcao.equals("SAIR"));

	}

	private static void cadastrarCurso() {
		Escola escola = EscolaApp.escolherEscola();
		CursosApp.incluirCurso(escola);

	}

	private static void cadastroNota() {

		Aluno aluno = AlunoApp.escolherAluno();
		Curso curso = CursosApp.escolherCurso(1);
		NotaApp.incluirNota(aluno, curso);

	}
}
