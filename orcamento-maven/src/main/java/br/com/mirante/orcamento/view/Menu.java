package br.com.mirante.orcamento.view;

import java.util.Scanner;

public abstract class Menu implements Funcionalidade {

	Scanner scanner = new Scanner(System.in);

	public void executar() {
		iprimirMenu();
		var opcaoSelecionada = scanner.next();

		while (!existe(opcaoSelecionada)) {
			System.out.println("A opção é inválida, tente novamente.");
			iprimirMenu();
			opcaoSelecionada = scanner.next();
		}

		processarOpcaoSelecionada(opcaoSelecionada);
	}
	
	protected abstract void iprimirMenu();
	protected abstract boolean existe(String opcaoSelecionada);
	protected abstract void processarOpcaoSelecionada(String opcaoSelecionada);
}