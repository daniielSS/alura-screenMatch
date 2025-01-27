package br.com.alura.screenmatch.daoJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.screenmatch.dao.UsuarioDao;
import br.com.alura.screenmatch.enums.TipoUsuario;
import br.com.alura.screenmatch.models.Usuario;

public class UsuarioDaoJdbc implements UsuarioDao {

	@Override
	public void cadastroUsuario(Usuario usuario, Connection connection) throws SQLException {
		PreparedStatement preparedStatement = null;
		
		try {
			String sql = "INSERT INTO SDANIEL.USUARIOS VALUES (?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			int index = 1;
			preparedStatement.setInt(index++, usuario.getIdUsuario());
			preparedStatement.setString(index++, usuario.getNome());
			preparedStatement.setString(index++, usuario.getSobrenome());
			preparedStatement.setString(index++, usuario.getEmail());
			preparedStatement.setString(index++, usuario.getSenha());
			usuario.setTipoUsuario(TipoUsuario.ADMIN);
			preparedStatement.setInt(index++, usuario.getTipoUsuario().getIdTipoUsuario());
			preparedStatement.executeUpdate();
		} finally {
			connection.close();
		}
	}
}
