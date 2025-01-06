package br.com.alura.screenmatch.models;

public class Serie extends Titulo {

	private int temporada;
	private int episodiosPorTemporada;

	public int getTemporada() {
		return temporada;
	}

	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}

	public int getEpisodioPorTemporada() {
		return episodiosPorTemporada;
	}

	public void setEpisodioPorTemporada(int episodiosPorTemporada) {
		this.episodiosPorTemporada = episodiosPorTemporada;
	}
	
	@Override
	public void exibirFichaTecnica() {
		System.out.println("Nome da S�rie: " + getNomeTitulo());
		System.out.println("Sinopse: " + getSinopseTitulo());
		System.out.println("Lan�amento: " + getAnoLancamento());
		System.out.println("Classifica��o Et�ria: " + getFaixaEtariaTitulo());
		System.out.println("M�dia Avalia��es: " + mediaAvaliacoes());
		System.out.println("Avalia��es: " + getTotalAvaliacoes());
		System.out.println("Temporadas: " + temporada);
		System.out.println("Epis�dios por Temporada: " + episodiosPorTemporada);
	}

}
