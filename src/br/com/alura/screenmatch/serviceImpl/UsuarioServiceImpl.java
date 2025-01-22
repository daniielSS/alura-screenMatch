package br.com.alura.screenmatch.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.screenmatch.application.DataSource;
import br.com.alura.screenmatch.dao.UsuarioDao;
import br.com.alura.screenmatch.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioDao usuarioDao;

	@Override
	public void cadastroUsuario(String nome, String sobrenome, String email, String senha) throws ClassNotFoundException, SQLException {
		DataSource dataSource = new DataSource();
		Connection connection = null;
		
		connection = dataSource.getConnection();
		usuarioDao.cadastroUsuario(nome, sobrenome, email, senha, connection);
		
		System.out.println("Usuário Cadastrado com sucesso!");
	}
}
