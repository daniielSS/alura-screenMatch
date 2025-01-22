package br.com.alura.screenmatch.daoJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.screenmatch.dao.UsuarioDao;
import br.com.alura.screenmatch.models.Usuario;

public class UsuarioDaoJdbc implements UsuarioDao {

	@Override
	public void cadastroUsuario(String nome, String sobrenome, String email, String senha, Connection connection) throws SQLException {
		Usuario usuario = new Usuario();
		PreparedStatement preparedStatement = null;
		
		try {
			String sql = "INSERT INTO USUARIOS VALUES (?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			int index = 1;
			preparedStatement.setString(index++, usuario.getNome());
			preparedStatement.setString(index++, usuario.getSobrenome());
			preparedStatement.setString(index++, usuario.getEmail());
			preparedStatement.setString(index++, usuario.getSenha());
			preparedStatement.setInt(index++, usuario.getTipoUsuario().getIdTipoUsuario());
			preparedStatement.executeUpdate();
		} finally {
			connection.close();
		}
	}
}
