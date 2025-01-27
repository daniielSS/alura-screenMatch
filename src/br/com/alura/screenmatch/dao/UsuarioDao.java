package br.com.alura.screenmatch.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.screenmatch.models.Usuario;

public interface UsuarioDao {
	
	void cadastroUsuario(Usuario usuario, Connection connection) throws SQLException;
	
}
