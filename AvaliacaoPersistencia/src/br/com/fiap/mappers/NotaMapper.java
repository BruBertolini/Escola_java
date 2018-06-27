package br.com.fiap.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.fiap.entidades.Nota;

public class NotaMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Nota nota = new Nota();
		
		nota.setIdNota(rs.getInt("ID"));
		nota.setNota(rs.getDouble("NOTA"));
		
		return nota;
	}

}
