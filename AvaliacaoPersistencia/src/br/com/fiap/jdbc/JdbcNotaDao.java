package br.com.fiap.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.fiap.entidades.Nota;

public class JdbcNotaDao {
	
private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {   
		this.jdbcTemplate = new JdbcTemplate(dataSource);  
	}   
	
	//incluir nota
	public void incluirNota (Nota nota) throws Exception{
		try {
			String sql = "INSERT INTO NOTA "
					+ "(ALUNOS_ID, CURSOS_ID, NOTA) VALUES (?, ?, ?) ";
			this.jdbcTemplate.update(sql, nota.getAluno().getIdAlunos(), nota.getCurso().getIdCursos(), nota.getNota());
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	//buscar nota

}
