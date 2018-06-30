package br.com.fiap.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.fiap.entidades.Escola;

public class EscolaMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Escola escola = new Escola();
		
		escola.setIdEscola(rs.getInt("IDESCOLA"));
		escola.setNome(rs.getString("NOME"));
		escola.setEndereco(rs.getString("ENDERECO"));
		escola.setTelefone(rs.getString("TELEFONE"));
		escola.setEmail(rs.getString("EMAIL"));
		
		return escola;
	}

}
