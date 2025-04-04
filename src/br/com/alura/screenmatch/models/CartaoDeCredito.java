package br.com.alura.screenmatch.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.alura.screenmatch.enums.TipoEmissores;

public class CartaoDeCredito {

	private String emissor;
	private String numeroCartao;
	private String titularCartao;
	private Date dataValidade;
	private String cvv;
	private TipoEmissores tipoEmissores;

	public String getTitularCartao() {
		return titularCartao;
	}

	public void setTitularCartao(String titularCartao) {
		this.titularCartao = titularCartao;
	}

	public TipoEmissores getTipoEmissores() {
		return tipoEmissores;
	}

	public void setTipoEmissores(TipoEmissores tipoEmissores) {
		this.tipoEmissores = tipoEmissores;
	}

	public String getEmissor() {
		return emissor;
	}

	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	public String validarEmissor(String numeroCartao) {
		String emissor = null;
		List<TipoEmissores> listEmissores = new ArrayList<>();
		listEmissores.add(TipoEmissores.MASTERCARD);
		listEmissores.add(TipoEmissores.VISA);
		
		char valorEmissor = numeroCartao.charAt(0);
		switch (valorEmissor) {
		case '5':
			emissor = listEmissores.get(0).name();
			break;
		case '4':
			emissor = listEmissores.get(1).name();
			break;
		default:
			System.out.println("Cartão Inválido!");
			break;
		}

//		if (numeroCartao.startsWith("5") || numeroCartao.startsWith("4")) {
//			char valorEmissor = numeroCartao.charAt(0);
//			switch (valorEmissor) {
//			case '5':
//				emissor = listEmissores.get(0).name();
//				break;
//			case '4':
//				emissor = listEmissores.get(1).name();
//				break;
//			default:
//				break;
//			}
//		}
		return emissor;
	}
}
