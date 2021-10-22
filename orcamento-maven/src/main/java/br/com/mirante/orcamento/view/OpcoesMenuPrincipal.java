package br.com.mirante.orcamento.view;

import java.util.stream.*;

public enum OpcoesMenuPrincipal {
	
	CADASTRAR_ORCAMENTO("1","Cadastrar Orcamento", new CadastrarOrcamentoUI()),
	LISTAR_ORCAMENTOS("2","Listar Orçamentos", new ListarOrcamentosUI()),
	DETALHAR_ORCAMENTO("3","Detalhar Orçamento", new DetalharOrcamentoUI()),
	SAIR("4","Sair", new Sair());
	
	private String numero;
	private String descricao;
	private Funcionalidade executor;
	
	private OpcoesMenuPrincipal(String numero,String descricao, Funcionalidade executor) {
		this.numero = numero;
		this.descricao = descricao;
		this.executor = executor;
	}
	
	public void exibir() {
		System.out.println("[" + numero + "] - " + descricao);
	}
	
	public void executar() {
		executor.executar();
	}

	static OpcoesMenuPrincipal get(String numero) {
		return Stream.of(values()).filter(m -> m.numero.equals(numero)).findFirst().orElse(null);
	}

	static boolean existe(String numero) {
		for (OpcoesMenuPrincipal menu : values()) {
			if(menu.numero.equals(numero)) {
				return true;
			}
		}
		return false;
	}
	
}