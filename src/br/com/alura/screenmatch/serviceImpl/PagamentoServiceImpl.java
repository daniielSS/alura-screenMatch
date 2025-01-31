package br.com.alura.screenmatch.serviceImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.alura.screenmatch.models.CartaoDeCredito;
import br.com.alura.screenmatch.service.PagamentoService;

public class PagamentoServiceImpl implements PagamentoService {

	@Override
	public void validarPagamento(String numeroCartao, String titular, String dataValidade, String cvv) throws ParseException {
		CartaoDeCredito cartao = new CartaoDeCredito();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dataValidadeFormat = dateFormat.parse(dataValidade);
		
		try {
			cartao.setNumeroCartao(numeroCartao);
			cartao.setTitularCartao(titular);
			cartao.setDataValidade(dataValidadeFormat);
			cartao.setCvv(cvv);
			
			File file = new File("C:\\desenvolvimento-estudos\\alura\\screenMatch\\scriptfiles\\cartoes-de-credito");
			
			if(file.createNewFile()) {
				setFile(file, dataValidade, numeroCartao, titular, cvv, cartao);
			} else {
				System.out.println("Arquivo já existe!");
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setFile(File file, String dataValidade, String numeroCartao, String titular, String cvv, CartaoDeCredito cartao) throws IOException, ParseException {
		cartao = new CartaoDeCredito();
		
		try {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("Número do cartão: " + cartao.getNumeroCartao());
			fileWriter.write("Nome Titular: " + cartao.getTitularCartao());
			fileWriter.write("Validade cartão: " + dataValidade);
			fileWriter.write("CVV" + cartao.getCvv());
			fileWriter.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
