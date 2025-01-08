package br.com.alura.screenmatch.application;

import br.com.alura.screenmatch.command.TituloCommand;
import br.com.alura.screenmatch.commandImpl.TituloCommandImpl;
import br.com.alura.screenmatch.models.Titulo;

public class App {

	static TituloCommand tituloCommand = new TituloCommandImpl();

	public static void main(String[] args) {
		Titulo titulo = new Titulo();

		tituloCommand.adicionarTitulo(titulo);
	}
}
