package br.com.alura.screenmatch.commandImpl;

import java.util.Scanner;

import br.com.alura.screenmatch.command.TituloCommand;
import br.com.alura.screenmatch.models.Titulo;
import br.com.alura.screenmatch.service.TituloService;
import br.com.alura.screenmatch.serviceImpl.TituloServiceImpl;

public class TituloCommandImpl implements TituloCommand {

	static TituloService tituloService = new TituloServiceImpl();

	@Override
	public void adicionarTitulo(Titulo titulo) {
		titulo = null;

		System.out.println("SCREENMATCH");
		System.out.println("O que você deseja adicionar?");
		System.out.println(" ");
		System.out.println("1- Filme");
		System.out.println("2- Serie");
		System.out.println(" ");
		System.out.println("0- Voltar");
		System.out.print(" ");
		System.out.print("E: ");

		try {
			Scanner scanner = new Scanner(System.in);
			int opcaoSelecionada = scanner.nextInt();

			switch (opcaoSelecionada) {
			case 0:
				adicionarTitulo(titulo);
				break;
			case 1:
				tituloService.adicionarTitulo(opcaoSelecionada, titulo);
				break;
			case 2:
				tituloService.adicionarTitulo(opcaoSelecionada, titulo);
				break;
			default:
				System.out.println("Opção Inválida!");
				adicionarTitulo(titulo);
				break;
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println("Opção Inválida!");
			adicionarTitulo(titulo);
		}
	}
}
