package br.com.alura.screenmatch.serviceImpl;

import java.util.Scanner;

import br.com.alura.screenmatch.models.Filme;
import br.com.alura.screenmatch.models.Serie;
import br.com.alura.screenmatch.models.Titulo;
import br.com.alura.screenmatch.service.TituloService;

public class TituloServiceImpl implements TituloService {

	public static final int FILME = 1;
	public static final int SERIE = 2;

	@Override
	public Titulo adicionarTitulo(int opcaoSelecionada, Titulo titulo) {
		titulo = new Titulo();
		try {
			Scanner scanner;
			if (opcaoSelecionada == FILME) {
				Filme filme = new Filme();

				System.out.print("Digite o nome do filme: ");
				scanner = new Scanner(System.in);
				filme.setNomeTitulo(scanner.nextLine());
				System.out.print(" ");

				System.out.print("Digite a sinopse: ");
				scanner = new Scanner(System.in);
				filme.setSinopseTitulo(scanner.nextLine());
				System.out.print(" ");

				System.out.print("Digite o ano de lançamento: ");
				scanner = new Scanner(System.in);
				filme.setAnoLancamento(scanner.nextLine());
				System.out.print(" ");

				System.out.print("Digite a faixa etária: ");
				scanner = new Scanner(System.in);
				filme.setFaixaEtariaTitulo(scanner.nextLine());
				System.out.print(" ");

				System.out.print("Digite o nome do diretor do filme: ");
				scanner = new Scanner(System.in);
				filme.setDiretor(scanner.nextLine());
				
				titulo.setFilme(filme);
				titulo.getFilme().exibirFichaTecnica();
			} else if (opcaoSelecionada == SERIE) {
				Serie serie = new Serie();

				System.out.print("Digite o nome da série: ");
				scanner = new Scanner(System.in);
				serie.setNomeTitulo(scanner.nextLine());
				System.out.print(" ");

				System.out.print("Digite a sinopse: ");
				scanner = new Scanner(System.in);
				serie.setSinopseTitulo(scanner.nextLine());
				System.out.print(" ");

				System.out.print("Digite o ano de lançamento: ");
				scanner = new Scanner(System.in);
				serie.setAnoLancamento(scanner.nextLine());
				System.out.print(" ");

				System.out.print("Digite a faixa etária: ");
				scanner = new Scanner(System.in);
				serie.setFaixaEtariaTitulo(scanner.nextLine());
				System.out.print(" ");

				System.out.print("Digite o número de temporadas: ");
				scanner = new Scanner(System.in);
				serie.setTemporada(scanner.nextInt());
				System.out.print(" ");

				System.out.print("Digite o número de episódios por temporada: ");
				scanner = new Scanner(System.in);
				serie.setEpisodioPorTemporada(scanner.nextInt());
				
				titulo.setSerie(serie);
				titulo.getSerie().exibirFichaTecnica();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return titulo;
	}
}
