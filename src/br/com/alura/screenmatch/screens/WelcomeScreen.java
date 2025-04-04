package br.com.alura.screenmatch.screens;

import java.util.Scanner;

import br.com.alura.screenmatch.enums.TipoEmissores;
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
		System.out.println("Plataforma com filmes, s�ries e muito mais, com apenas uma assinatura.");
		System.out.println(" ");
		System.out.println("A partir de R$ 14,90. Cancele quando quiser.");
		System.out.println(" ");
		System.out.println("J� � assinante? Pressione [1] para acessar sua conta.");
		System.out.println("� novo por aqui? Pressione [2] agora mesmo para dar inicio ao cadastro de uma nova conta.");
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
				System.out.println("Op��o Inv�lida!");
				iniciarApp();
				break;
			}
		} catch (Exception e) {
			System.out.println("Op��o Inv�lida!");
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

			isValid = validarCredenciais(email, senha, isValid);

			if(isValid) {
				isAssinante = validarAssinatura(isAssinante);
			}

			if(isAssinante) {
				homePage.inicio();
			} else {
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
			System.out.println("--- Preencha os dados b�sicos ---");
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean validarCredenciais(String email, String senha, boolean isValid) throws Exception {
		Usuario usuario = new Usuario();

		usuario.setNome("Teste");
		usuario.setSobrenome("Usuario");
		usuario.setEmail("testeapp.g@gmail.com");
		usuario.setSenha("4417");

		if (email.equals(usuario.getEmail()) && senha.equals(usuario.getSenha())) {
			isValid = true;
		} else {
			System.out.println("Usuario/Senha inv�lidos!");
			isValid = false;
		}
		return isValid;
	}

	public boolean validarAssinatura(boolean isAssinante) throws Exception {
		Usuario usuario = new Usuario();
		Scanner scanner = null;
		String opcao;

		usuario.setNome("Teste");
		usuario.setSobrenome("Usuario");
		usuario.setEmail("testeapp.g@gmail.com");
		usuario.setSenha("4417");
		usuario.setAssinaturaAtiva(true);

		if (usuario.isAssinaturaAtiva()) {
			System.out.println("Bem-vindo " + usuario.getNomeUsuario() + "!");
			isAssinante = true;
		} else {
			System.out.println("Voc� n�o � assinante :(");
			System.out.println(" ");
			System.out.print("Deseja realizar a assinatura? [S/N]: ");

			scanner = new Scanner(System.in);
			opcao = scanner.nextLine();

			if (opcao.equals("S") || opcao.equals("s")) {
				assinar();
				scanner.close();
			}
		}
		return isAssinante;
	}

	public void assinar() throws Exception {
		Scanner scannerOpcao;

		System.out.println("Agora que voc� j� possu� uma conta, vamos para sele��o de um plano. Escolha o plano que melhor cabe no seu bolso.");
		System.out.println(" ");
		System.out.println("1- Plano Padr�o - R$ 14,90");
		System.out.println(" ");
		System.out.println("- Qualidades dispon�veis: HD, Full HD e 4K.");
		System.out.println("- Todo cat�logo de filmes e s�ries.");
		System.out.println("- Acesso simult�neo at� 3 telas.");
		System.out.println(" ");
		System.out.println("2- Plano Personalizado - Valor base: R$ 4,90");
		System.out.println(" ");
		System.out.println("- Todos os itens do plano padr�o.");
		System.out.println("- Assinaturas extras de outros streamings.");
		System.out.println(" ");
		System.out.print("E: ");

		scannerOpcao = new Scanner(System.in);
		int opcao = scannerOpcao.nextInt();

		switch (opcao) {
		case 1:
			pagamentoPlanoPadrao();
			break;
		case 2:
			pagamentoPlanoPersonal();
			break;
		default:
			System.out.println("Op��o Inv�lida!");
			assinar();
			break;
		}
		scannerOpcao.close();
	}

	private void pagamentoPlanoPadrao() throws Exception {
		CartaoDeCredito cartao = new CartaoDeCredito();
		boolean isValid = false;
		String numeroCartao = null;
		Scanner scannerNumeroCartao;
		Scanner scannerTitular;
		Scanner scannerDataValidade;
		Scanner scannerCvv;
		Scanner scannerOpcao;
		
		try {
			System.out.println("�tima escolha! Agora vamos seguir para o pagamento :) ");
			System.out.println(" ");
			System.out.println("Preencha os pr�ximos campos com os dados do seu cart�o de cr�dito: ");
			System.out.println(" ");
			System.out.println("Ser�o aceitos apenas cart�es MasterCard e Visa.");
			System.out.println(" ");

			scannerNumeroCartao = new Scanner(System.in);

			do {
				System.out.print("Informe o numero do cart�o: ");
				numeroCartao = scannerNumeroCartao.nextLine();
				String emissorCartao = cartao.validarEmissor(numeroCartao);

				if (emissorCartao.equals(TipoEmissores.MASTERCARD.name()) || emissorCartao.equals(TipoEmissores.VISA.name())) {
					isValid = true;
				}
			} while (!isValid);

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
			System.out.print("Confirma as informa��es inseridas acima? [S/N]: ");
			scannerOpcao = new Scanner(System.in);
			String opcao = scannerOpcao.nextLine();

			if (opcao.equals("S") || opcao.equals("s")) {
				pagamentoService.validarPagamento(numeroCartao, titular, dataValidade, cvv);
				System.out.println("Pagamento Aprovado! Seja bem-vindo ao ScreenMatch :)");
				homePage.inicio();
			} else if (opcao.equals("N") || opcao.equals("n")) {
				pagamentoPlanoPadrao();
			}
			scannerNumeroCartao.close();
			scannerTitular.close();
			scannerCvv.close();
			scannerDataValidade.close();
			scannerOpcao.close();
		} catch (Exception e) {
			System.out.println("Cart�o Inv�lido!");
		}
	}

	private void pagamentoPlanoPersonal() {
		System.out.println("Op��o indispon�vel no momento!");
	}
}
