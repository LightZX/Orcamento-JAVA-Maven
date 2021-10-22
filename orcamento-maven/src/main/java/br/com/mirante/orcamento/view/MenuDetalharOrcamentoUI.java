package br.com.mirante.orcamento.view;

import java.util.stream.Stream;

public class MenuDetalharOrcamentoUI extends Menu {
	 
	public void exibir() {
		
	}
	
	protected void iprimirMenu() {
		System.out.println("===================================================");
		System.out.println("Digite um número correspondente a opção desejada:");
		Stream.of(OpcoesMenuDetalharOrcamento.values()).forEach(OpcoesMenuDetalharOrcamento::exibir);
	}

	protected void processarOpcaoSelecionada(String opcaoSelecionada) {
		System.out.println("A opção selecionada foi " + opcaoSelecionada);
		OpcoesMenuDetalharOrcamento.get(opcaoSelecionada).executar();
	}



	@Override
	protected boolean existe(String opcaoSelecionada) {
		return OpcoesMenuDetalharOrcamento.existe(opcaoSelecionada);
	}
}
