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
		System.out.println("Nome da Série: " + getNomeTitulo());
		System.out.println("Sinopse: " + getSinopseTitulo());
		System.out.println("Lançamento: " + getAnoLancamento());
		System.out.println("Classificação Etária: " + getFaixaEtariaTitulo());
		System.out.println("Média Avaliações: " + mediaAvaliacoes());
		System.out.println("Avaliações: " + getTotalAvaliacoes());
		System.out.println("Temporadas: " + temporada);
		System.out.println("Episódios por Temporada: " + episodiosPorTemporada);
	}

}
