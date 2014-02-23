package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import to.Profissional;
import factory.ConnectionFactory;

public class ProfissionalDAO {

	public ArrayList<Profissional> getAll() throws SQLException{
		
		ArrayList<Profissional> profissionais = new ArrayList<Profissional>();
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "SELECT * FROM profissional ORDER BY nome";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			
			Profissional l = new Profissional();
			l.setCpf(rs.getString("cpf"));
			l.setNome(rs.getString("nome"));
			l.setValor(rs.getDouble("valor"));
			
			profissionais.add(l);
		}

		conn.close();
		
		return profissionais;
	}
	
}
