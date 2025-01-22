package br.com.alura.screenmatch.enums;

public enum TipoUsuario {
	VISITANTE(2, "Visitante"), ASSINANTE(1, "Assinante"), ADMIN(0, "Admin");
	
	private int idTipoUsuario;
	private String descricao;
	
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	TipoUsuario(int id, String descricao) {
		this.idTipoUsuario = id;
		this.descricao = descricao;
	}
}
