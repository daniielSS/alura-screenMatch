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
		System.out.println("Lan�amento: " + getAnoLancamento());
		System.out.println("Classifica��o Et�ria: " + getFaixaEtariaTitulo());
		System.out.println("M�dia Avalia��es: " + mediaAvaliacoes());
		System.out.println("Avalia��es: " + getTotalAvaliacoes());
		System.out.println("Dirigido por: " + diretor);
	}

}
