package br.com.alura.screenmatch.application;

import java.util.Random;

import br.com.alura.screenmatch.models.Filme;
import br.com.alura.screenmatch.models.Serie;

public class App {

	public static void main(String[] args) {
		Filme filme = new Filme();
		Serie serie = new Serie();

		adicionarFilme(filme);
		adicionarSerie(serie);

		filme.exibirFichaTecnica();
		System.out.println(" ");
		serie.exibirFichaTecnica();
	}

	private static void adicionarFilme(Filme filme) {
		int avaliacaoMinima = 1;
		int avaliacaoMaxima = 5;

		filme.setNomeTitulo("Sonic O Filme");
		filme.setSinopseTitulo(
				"O porco-espinho Sonic é teletransportado para a Terra. Após causar uma pane elétrica em parte dos Estados Unidos, "
						+ "ele precisa escapar do maligno cientista Dr. Robotnik.");
		filme.setAnoLancamento("2020");
		filme.setFaixaEtariaTitulo("10 Anos");
		filme.setDiretor("Jeff Fowler");

		for (int i = 1; i <= 100; i++) {
			Random random = new Random();
			int randNumber = random.nextInt(avaliacaoMaxima - avaliacaoMinima + 1) + avaliacaoMinima;
			filme.avaliarTitulo(randNumber);
		}
	}

	private static void adicionarSerie(Serie serie) {
		int avaliacaoMinima = 1;
		int avaliacaoMaxima = 5;

		serie.setNomeTitulo("F1: Dirigir para Viver");
		serie.setSinopseTitulo("Fórmula 1 - Dirigir para Viver dá um mergulho no universo da Fórmula 1, "
				+ "desde os bastidores do Campeonato Mundial até o funcionamento das dependências de autódromos. "
				+ "Velocidade, tensão e rivalidade, com direito a depoimentos exclusivos de pilotos e diretores do torneio principal.");
		serie.setAnoLancamento("2019");
		serie.setFaixaEtariaTitulo("12 Anos");
		serie.setEpisodioPorTemporada(10);
		serie.setTemporada(6);

		for (int i = 1; i <= 125; i++) {
			Random random = new Random();
			int randNumber = random.nextInt(avaliacaoMaxima - avaliacaoMinima + 1) + avaliacaoMinima;
			serie.avaliarTitulo(randNumber);
		}
	}
}
