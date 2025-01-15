package br.com.alura.screenmatch.application;

import static br.com.alura.screenmatch.enums.TipoUsuario.*;

import java.util.Scanner;

import br.com.alura.screenmatch.enums.TipoUsuario;
import br.com.alura.screenmatch.models.Usuario;

public class WelcomeScreen {

	public void iniciarApp() {
		Scanner scanner;

		System.out.println("SCREENMATCH");
		System.out.println(" ");
		System.out.println("Plataforma com filmes, séries e muito mais, com apenas uma assinatura.");
		System.out.println(" ");
		System.out.println("A partir de R$ 14,90. Cancele quando quiser.");
		System.out.println(" ");
		System.out.println("Já é assinante? Pressione [1] para acessar sua conta.");
		System.out.println("É novo por aqui? Pressione [2] agora mesmo para dar inicio ao cadastro de uma nova conta.");
		System.out.println(" ");
		System.out.print("E: ");

		try {
			scanner = new Scanner(System.in);
			int opcaoSelecionada = scanner.nextInt();

			switch (opcaoSelecionada) {
			case 1:
				loginUsuario();
				break;
			case 2:
				cadastroUsuario();
				break;
			default:
				System.out.println("Opção Inválida!");
				iniciarApp();
				break;
			}
		} catch (Exception e) {
			System.out.println("Opção Inválida!");
			iniciarApp();
		}
	}

	public void loginUsuario() {
		boolean isValid = false;
		Scanner scannerEmail;
		Scanner scannerSenha;

		try {
			System.out.print("Digite seu email: ");
			scannerEmail = new Scanner(System.in);
			String email = scannerEmail.nextLine();

			System.out.print("Digite sua senha: ");
			scannerSenha = new Scanner(System.in);
			String senha = scannerSenha.nextLine();

			isValid = validarCredenciais(email, senha, isValid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cadastroUsuario() {
		
	}

	public boolean validarCredenciais(String email, String senha, boolean isValid) {
		Usuario usuario = new Usuario();

		if (email.equals(usuario.getEmail()) && senha.equals(usuario.getSenha())) {
			if (usuario.getTipoUsuario() == TipoUsuario.ASSINANTE) {
				System.out.println("Bem-vindo " + usuario.getUsuario() + "!");
				isValid = true;
			} else {
				System.out.println("Você não é assinante :(");
			}
		} else {
			System.out.println("Usuario/Senha inválidos!");
			isValid = false;
		}
		return isValid;
	}
}
