package br.com.alura.screenmatch.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.screenmatch.application.DataSource;
import br.com.alura.screenmatch.dao.UsuarioDao;
import br.com.alura.screenmatch.daoJdbc.UsuarioDaoJdbc;
import br.com.alura.screenmatch.models.Usuario;
import br.com.alura.screenmatch.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
	
	static UsuarioDao usuarioDao = new UsuarioDaoJdbc();

	@Override
	public void cadastroUsuario(String nome, String sobrenome, String email, String senha) throws ClassNotFoundException, SQLException {
		DataSource dataSource = new DataSource();
		Usuario usuario = new Usuario();
		Connection connection = null;
		
		connection = dataSource.getConnection();
		usuario.setIdUsuario(1);
		usuario.setNome(nome);
		usuario.setSobrenome(sobrenome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuarioDao.cadastroUsuario(usuario, connection);
		System.out.println("Usuário Cadastrado com sucesso!");
	}
}
