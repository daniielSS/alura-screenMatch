package br.com.alura.screenmatch.enums;

public enum TipoEmissores {
	MASTERCARD(5), VISA(4);

	private int idTipoEmissor;

	public int getIdTipoEmissor() {
		return idTipoEmissor;
	}

	public void setIdTipoEmissor(int idTipoEmissor) {
		this.idTipoEmissor = idTipoEmissor;
	}

	TipoEmissores(int idTipoEmissor) {
		this.idTipoEmissor = idTipoEmissor;
	}
}
