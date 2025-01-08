package br.com.alura.screenmatch.models;

public class Titulo {

	private String nomeTitulo;
	private String sinopseTitulo;
	private String faixaEtariaTitulo;
	private double somaAvaliacoes;
	private int totalAvaliacoes;
	private String anoLancamento;
	private Filme filme;
	private Serie serie;

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getNomeTitulo() {
		return nomeTitulo;
	}

	public void setNomeTitulo(String nomeTitulo) {
		this.nomeTitulo = nomeTitulo;
	}

	public String getSinopseTitulo() {
		return sinopseTitulo;
	}

	public void setSinopseTitulo(String sinopseTitulo) {
		this.sinopseTitulo = sinopseTitulo;
	}

	public String getFaixaEtariaTitulo() {
		return faixaEtariaTitulo;
	}

	public void setFaixaEtariaTitulo(String faixaEtariaTitulo) {
		this.faixaEtariaTitulo = faixaEtariaTitulo;
	}

	public double getSomaAvaliacoes() {
		return somaAvaliacoes;
	}

	public int getTotalAvaliacoes() {
		return totalAvaliacoes;
	}
	
	public void exibirFichaTecnica() {
		System.out.println(nomeTitulo);
		System.out.println(sinopseTitulo);
		System.out.println(anoLancamento);
		System.out.println(faixaEtariaTitulo);
		System.out.println(totalAvaliacoes);
	}
	
	public void avaliarTitulo(int avaliacao) {
		somaAvaliacoes += avaliacao;
		totalAvaliacoes++;
	}
	
	public double mediaAvaliacoes() {
		return somaAvaliacoes / totalAvaliacoes;
	}
	
}
