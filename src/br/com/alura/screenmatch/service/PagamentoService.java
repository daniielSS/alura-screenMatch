package br.com.alura.screenmatch.service;

import java.text.ParseException;

public interface PagamentoService {
	
	void validarPagamento(String numeroCartao, String titular, String dataValidade, String cvv) throws ParseException;
	
}
