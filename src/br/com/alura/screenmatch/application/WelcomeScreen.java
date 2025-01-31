package br.com.alura.screenmatch.application;

import java.text.ParseException;
import java.util.Scanner;

import br.com.alura.screenmatch.enums.TipoEmissores;
import br.com.alura.screenmatch.enums.TipoUsuario;
import br.com.alura.screenmatch.models.CartaoDeCredito;
import br.com.alura.screenmatch.models.Usuario;
import br.com.alura.screenmatch.service.PagamentoService;
import br.com.alura.screenmatch.service.UsuarioService;
import br.com.alura.screenmatch.serviceImpl.PagamentoServiceImpl;
import br.com.alura.screenmatch.serviceImpl.UsuarioServiceImpl;

public class WelcomeScreen {
	
	static UsuarioService usuarioService = new UsuarioServiceImpl();
	static HomePage homePage = new HomePage();
	static PagamentoService pagamentoService = new PagamentoServiceImpl();

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
		boolean isAssinante = false;
		Scanner scannerEmail;
		Scanner scannerSenha;

		try {
			System.out.print("Digite seu email: ");
			scannerEmail = new Scanner(System.in);
			String email = scannerEmail.nextLine();

			System.out.print("Digite sua senha: ");
			scannerSenha = new Scanner(System.in);
			String senha = scannerSenha.nextLine();

			isValid = validarCredenciais(email, senha, isValid, isAssinante);
						
			if(isAssinante && isValid) {
				homePage.inicio();
			} else if(isAssinante == false && isValid == true) {
				assinar();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cadastroUsuario() {
		Scanner scannerNome;
		Scanner scannerSobrenome;
		Scanner scannerEmail;
		Scanner scannerSenha;
		
		try {
			System.out.println("--- Preencha os dados básicos ---");
			System.out.println(" ");
			
			System.out.print("Digite seu nome: ");
			scannerNome = new Scanner(System.in);
			String nome = scannerNome.nextLine();
			
			System.out.print("Digite seu sobrenome: ");
			scannerSobrenome = new Scanner(System.in);
			String sobrenome = scannerSobrenome.nextLine();
			
			System.out.print("Digite seu e-mail: ");
			scannerEmail = new Scanner(System.in);
			String email = scannerEmail.nextLine();
			
			System.out.print("Digite uma senha: ");
			scannerSenha = new Scanner(System.in);
			String senha = scannerSenha.nextLine();
			
			usuarioService.cadastroUsuario(nome, sobrenome, email, senha);
			
			System.out.println("SCREENMATCH");
			System.out.println(" ");

			loginUsuario();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public boolean validarCredenciais(String email, String senha, boolean isValid, boolean isAssinante) {
		Usuario usuario = new Usuario();

		if (email.equals(usuario.getEmail()) && senha.equals(usuario.getSenha())) {
			if (usuario.getTipoUsuario() == TipoUsuario.ASSINANTE) {
				System.out.println("Bem-vindo " + usuario.getNomeUsuario() + "!");
				isValid = true;
				isAssinante = true;
			} else {
				System.out.println("Você não é assinante :(");
			}
		} else {
			System.out.println("Usuario/Senha inválidos!");
			isValid = false;
		}
		return isValid;
	}
	
	public void assinar() throws ParseException {
		Scanner scannerOpcao;
		
		System.out.println("Agora que você já possuí uma conta, vamos para seleção de um plano. Escolha o plano que melhor cabe no seu bolso.");
		System.out.println(" ");
		System.out.println("1- Plano Padrão - R$ 14,90");
		System.out.println(" ");
		System.out.println("- Qualidades disponíveis: HD, Full HD, Quad HD e 4K.");
		System.out.println("- Todo catálogo de filmes e séries.");
		System.out.println("- Acesso simultâneo até 3 telas.");
		System.out.println(" ");
		System.out.println("2- Plano Personalizado - Valor base: R$ 4,90");
		System.out.println(" ");
		System.out.println("- Todos os itens do plano padrão.");
		System.out.println("- Assinaturas extras de outros streamings.");
		System.out.println(" ");
		System.out.println("E; ");
		
		scannerOpcao = new Scanner(System.in);
		int opcao = scannerOpcao.nextInt();
		
		switch(opcao) {
		case 1:
			pagamentoPlanoPadrao();
			break;
		case 2:
			pagamentoPlanoPersonal();
			break;
		default:
			System.out.println("Opção Inválida!");
			assinar();
			break;
		}
		scannerOpcao.close();
	}
	
	private void pagamentoPlanoPadrao() throws ParseException {
		CartaoDeCredito cartao = new CartaoDeCredito();
		boolean isInvalid = false;
		String numeroCartao = null;
		Scanner scannerNumeroCartao;
		Scanner scannerTitular;
		Scanner scannerDataValidade;
		Scanner scannerCvv;
		Scanner scannerOpcao;
		
		System.out.println("Ótima escolha! Agora vamos seguir para o pagamento :) ");
		System.out.println(" ");
		System.out.println("Preencha os próximos campos com os dados do seu cartão de crédito: ");
		System.out.println(" ");
		System.out.println("Serão aceitos apenas cartões MasterCard e Visa.");
		System.out.println(" ");
		
		while(isInvalid == false) {
			System.out.print("Informe o numero do cartão: ");
			scannerNumeroCartao = new Scanner(System.in);
			numeroCartao = scannerNumeroCartao.nextLine();
			String emissorCartao = cartao.validarEmissor(numeroCartao);
			
			if(emissorCartao.equals(TipoEmissores.MASTERCARD.name()) || emissorCartao.equals(TipoEmissores.VISA.name())) {
				isInvalid = true;
			}
			scannerNumeroCartao.close();
		}
		
		System.out.print("Informe o nome do titular: ");
		scannerTitular = new Scanner(System.in);
		String titular = scannerTitular.nextLine();
		
		System.out.print("Informe a data de validade: ");
		scannerDataValidade = new Scanner(System.in);
		scannerDataValidade.useDelimiter("/");
		String dataValidade = scannerDataValidade.nextLine();
		
		System.out.print("Informe o CVV: ");
		scannerCvv = new Scanner(System.in);
		String cvv = scannerCvv.nextLine();
		
		System.out.println(" ");
		System.out.print("Confirma as informações inseridas acima? [S/N]: ");
		scannerOpcao = new Scanner(System.in);
		String opcao = scannerOpcao.nextLine();
		
		if(opcao.equals("S") || opcao.equals("s")) {
			pagamentoService.validarPagamento(numeroCartao, titular, dataValidade, cvv);
			System.out.println("Pagamento Aprovado! Seja bem-vindo ao ScreenMatch :)");
			homePage.inicio();
		} else if(opcao.equals("N") || opcao.equals("n")) {
			pagamentoPlanoPadrao();
		}
		scannerCvv.close();
		scannerDataValidade.close();
		scannerOpcao.close();
		scannerTitular.close();
	}
	
	private void pagamentoPlanoPersonal() {
		
	}
}
