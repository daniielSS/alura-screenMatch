package br.com.alura.screenmatch.service;

import java.sql.Connection;
import java.sql.SQLException;

public interface UsuarioService {
	
	void cadastroUsuario(String nome, String sobrenome, String email, String senha) throws ClassNotFoundException, SQLException;
	
}
