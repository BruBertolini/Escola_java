package br.com.fiap.app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fiap.entidades.Escola;
import br.com.fiap.jdbc.JdbcEscolaDao;

public class EscolaApp {

	public static void incluirEscola() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("beansJdbc.xml");
			JdbcEscolaDao dao = (JdbcEscolaDao) context.getBean("jdbcEscolaDao");

			Escola escola = new Escola();
			escola.setNome(JOptionPane.showInputDialog("Nome da escola: "));
			escola.setEndereco(JOptionPane.showInputDialog("Endereco: "));
			escola.setTelefone(JOptionPane.showInputDialog("Telefone: "));
			escola.setEmail(JOptionPane.showInputDialog("Email: "));

			dao.incluirEscola(escola);
			JOptionPane.showMessageDialog(null, "Escola inclui­da com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Escola escolherEscola() {

		ApplicationContext context = new ClassPathXmlApplicationContext("beansJdbc.xml");
		JdbcEscolaDao dao = (JdbcEscolaDao) context.getBean("jdbcEscolaDao");
		
		List<Escola> listaEscola = null;
		try {
			listaEscola = dao.listarEscolas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Object[] choices = new Object[listaEscola.size()];
		
		int contador = 0;
		for (Escola escola : listaEscola) {
			choices[contador] = escola;
			contador++;
		}

		Escola input = (Escola) JOptionPane.showInputDialog(null, "Escola", "Escolha uma escola:",
				JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

		return input;
	}

}
