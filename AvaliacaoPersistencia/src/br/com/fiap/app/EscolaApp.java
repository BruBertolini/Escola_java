package br.com.fiap.app;

import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fiap.entidades.Escola;
import br.com.fiap.jdbc.JdbcEscolaDao;

public class EscolaApp {
	
	public static void main(String[] args) {
		
		 incluirEscola();
	}
		
	private static void incluirEscola() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("beansJdbc.xml");
			JdbcEscolaDao dao = (JdbcEscolaDao) context.getBean("jdbcEscolaDao");

			Escola escola = new Escola();
			escola.setNome(JOptionPane.showInputDialog("Nome da escola: "));
			escola.setEndereco(JOptionPane.showInputDialog("Endereço: "));
			escola.setTelefone(JOptionPane.showInputDialog("Telefone: "));
			escola.setEmail(JOptionPane.showInputDialog("Email: "));

			dao.incluirEscola(escola);
			JOptionPane.showMessageDialog(null, "Escola incluída com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	
}
	
