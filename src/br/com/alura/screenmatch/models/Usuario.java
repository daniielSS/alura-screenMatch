package br.com.alura.screenmatch.models;

import br.com.alura.screenmatch.enums.TipoUsuario;

public class Usuario {

	private int idUsuario;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private TipoUsuario tipoUsuario;
	private CartaoDeCredito cartaoDeCredito;

	public CartaoDeCredito getCartaoDeCredito() {
		return cartaoDeCredito;
	}

	public void setCartaoDeCredito(CartaoDeCredito cartaoDeCredito) {
		this.cartaoDeCredito = cartaoDeCredito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public String getNomeUsuario() {
		String espaco = " ";
		String nomeUsuario = nome.concat(espaco.concat(sobrenome));
		return nomeUsuario;
	}

}
