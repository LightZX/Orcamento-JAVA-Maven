package br.com.mirante.orcamento.view;

import java.util.stream.Stream;

public class MenuPrincipal extends Menu {
	
	protected void iprimirMenu() {
		System.out.println("===================================================");
		System.out.println("Digite um n�mero correspondente a op��o desejada:");
		Stream.of(OpcoesMenuPrincipal.values()).forEach(OpcoesMenuPrincipal::exibir);
	}

	protected void processarOpcaoSelecionada(String opcaoSelecionada) {
		System.out.println("A op��o selecionada foi " + opcaoSelecionada);
		OpcoesMenuPrincipal.get(opcaoSelecionada).executar();
	}



	@Override
	protected boolean existe(String opcaoSelecionada) {
		return OpcoesMenuPrincipal.existe(opcaoSelecionada);
	}
	
}