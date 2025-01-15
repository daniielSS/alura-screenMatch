package br.com.alura.screenmatch.enums;

public enum TipoUsuario {
	VISITANTE(2, "Visitante"), ASSINANTE(1, "Assinante"), ADMIN(0, "Admin");
	
	private int idTipoUsuario;
	private String descricao;
	
	TipoUsuario(int id, String descricao) {
		this.idTipoUsuario = id;
		this.descricao = descricao;
	}
}
