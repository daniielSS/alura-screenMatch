package br.com.alura.screenmatch.screens;

import java.util.Scanner;

public class HomePage {

	public void inicio() {
		Scanner scanner;

		System.out.println("O que você vai assistir hoje?");
		System.out.println(" ");
		System.out.println("1- Filmes");
		System.out.println(" ");
		System.out.println("2- Series");
		System.out.println(" ");
		System.out.print("E: ");

		scanner = new Scanner(System.in);
		String opcao = scanner.nextLine();
	}

}
