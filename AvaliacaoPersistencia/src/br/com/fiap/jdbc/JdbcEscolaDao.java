package br.com.fiap.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.fiap.entidades.Escola;
import br.com.fiap.mappers.EscolaMapper;

public class JdbcEscolaDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {   
		this.jdbcTemplate = new JdbcTemplate(dataSource);  
	}   
	
	//incluir escola
	public void incluirEscola(Escola escola) throws Exception {
		
		try {
			String sql = "INSERT INTO ESCOLA "
					+ "(NOME, ENDERECO, TELEFONE, EMAIL) VALUES (?, ?, ?, ?)";
			this.jdbcTemplate.update(sql, escola.getNome(), escola.getEndereco(), escola.getTelefone(), escola.getEmail());
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	//buscar escola
	public Escola buscarEscola(int id) throws Exception {
		
		Escola escola = null;
		
		try {
			String query = "SELECT * FROM ESCOLA WHERE ID = ? ";
			escola = (Escola) this.jdbcTemplate.queryForObject(query, new Integer[] { id }, new EscolaMapper());
			
		} catch (Exception e) {
			throw e;
		}
		
		return escola;
		
	}
	
	//listar todas as escolas 
		public List<Escola> listarEscolas() throws Exception {   
			List<Escola> escolas = new ArrayList<>();     
				try {    
					escolas = this.jdbcTemplate.query(
							"SELECT * FROM ESCOLA",      
							new EscolaMapper());      
					} catch (Exception e) {    
						throw e;   
					}   
				return escolas;  
		} 

}
