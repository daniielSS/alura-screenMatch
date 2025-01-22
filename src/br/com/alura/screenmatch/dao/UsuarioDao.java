package br.com.alura.screenmatch.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface UsuarioDao {
	
	void cadastroUsuario(String nome, String sobrenome, String email, String senha, Connection connection) throws SQLException;
	
}
