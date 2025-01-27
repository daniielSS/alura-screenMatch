package br.com.alura.screenmatch.enums;

public enum TipoUsuario {
	VISITANTE(2), ASSINANTE(1), ADMIN(0);
	
	private int idTipoUsuario;
	
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	TipoUsuario(int id) {
		this.idTipoUsuario = id;
	}
}
