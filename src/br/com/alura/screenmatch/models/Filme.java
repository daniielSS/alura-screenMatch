package br.com.alura.screenmatch.models;

public class Filme extends Titulo {

	private String diretor;

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	
	@Override
	public void exibirFichaTecnica() {
		System.out.println("Nome do Filme: " + getNomeTitulo());
		System.out.println("Sinopse: " + getSinopseTitulo());
		System.out.println("Lançamento: " + getAnoLancamento());
		System.out.println("Classificação Etária: " + getFaixaEtariaTitulo());
		System.out.println("Média Avaliações: " + mediaAvaliacoes());
		System.out.println("Avaliações: " + getTotalAvaliacoes());
		System.out.println("Dirigido por: " + diretor);
	}

}
