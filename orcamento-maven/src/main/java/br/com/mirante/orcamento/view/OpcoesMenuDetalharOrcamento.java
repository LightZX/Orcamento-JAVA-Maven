package br.com.mirante.orcamento.view;

import java.util.stream.*;

public enum OpcoesMenuDetalharOrcamento {
	
	EDITAR_ITEM("1","Editar Item", null),
	EXCLUIR_ITEM("2","Excluir Item", new ExcluirItemOrcamento()),
	MENU_PRINCIPAL("3","Retornar ao Menu Principal", new MenuPrincipal()),
	SAIR("4","Sair", new Sair());
	
	private String numero;
	private String descricao;
	private Funcionalidade executor;
	
	private OpcoesMenuDetalharOrcamento(String numero,String descricao, Funcionalidade executor) {
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

	static OpcoesMenuDetalharOrcamento get(String numero) {
		return Stream.of(values()).filter(m -> m.numero.equals(numero)).findFirst().orElse(null);
	}

	static boolean existe(String numero) {
		for (OpcoesMenuDetalharOrcamento menu : values()) {
			if(menu.numero.equals(numero)) {
				return true;
			}
		}
		return false;
	}
	
}