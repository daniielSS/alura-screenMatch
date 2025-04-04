package br.com.alura.screenmatch.serviceImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import br.com.alura.screenmatch.constantes.Constantes;
import br.com.alura.screenmatch.models.CartaoDeCredito;
import br.com.alura.screenmatch.service.PagamentoService;

public class PagamentoServiceImpl implements PagamentoService {

	@Override
	public void validarPagamento(String numeroCartao, String titular, String dataValidade, String cvv) throws ParseException {
		CartaoDeCredito cartao = new CartaoDeCredito();
		DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
		Date dataValidadeFormat = dateFormat.parse(dataValidade);
		Properties properties = new Properties();
		Path enviroment = Paths.get("/scriptfiles/environment-variables/" + Constantes.DEV_PROPERTIES);

		try {
			cartao.setNumeroCartao(numeroCartao);
			cartao.setTitularCartao(titular);
			cartao.setDataValidade(dataValidadeFormat);
			cartao.setCvv(cvv);

			InputStream inputStream = Files.newInputStream(enviroment);
			properties.load(inputStream);

			Object urlCartaoDeCredito = properties.get("URL_CARTAODECREDITO")

			File file = new File(urlCartaoDeCredito + Constantes.NOME_ARQUIVO + Constantes.SEQ_CARTAO + Constantes.EXTENSAO_TXT);

			if(file.createNewFile()) {
				setFile(file, dataValidade, numeroCartao, titular, cvv, cartao);
			} else {
				System.out.println("Arquivo j� existe!");
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void setFile(File file, String dataValidade, String numeroCartao, String titular, String cvv, CartaoDeCredito cartao) throws IOException, ParseException {
		try {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("N�mero do cart�o: " + cartao.getNumeroCartao() + "\n");
			fileWriter.write("Nome Titular: " + cartao.getTitularCartao() + "\n");
			fileWriter.write("Validade cart�o: " + dataValidade + "\n");
			fileWriter.write("CVV: " + cartao.getCvv() + "\n");
			fileWriter.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
