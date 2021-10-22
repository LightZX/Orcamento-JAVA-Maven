package br.com.mirante.orcamento.view;

import java.util.Scanner;

import br.com.mirante.orcamento.domain.ItemOrcamento;
import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.servico.DetalharOrcamentoServico;

public class DetalharOrcamentoUI implements Funcionalidade {
	private Scanner sc = new Scanner(System.in);
	private DetalharOrcamentoServico servico = new DetalharOrcamentoServico();

	public void executar() {
		System.out.println("Digite o c�digo do or�amento:");
		int id = sc.nextInt();
		
		Orcamento orcamentoRecuperado = servico.recuperar(id);
		if(orcamentoRecuperado == null) {
			System.out.println("O or�amento com o c�digo " + id + " n�o foi encontrado.");
			
		}else {
			UIUtils.imprimirOrcamento(orcamentoRecuperado);
			System.out.println("Itens: ");
			for (ItemOrcamento item : orcamentoRecuperado.getItensOrcamento()) {
				UIUtils.exibirItemOrcamento(item);
			}
		}
		
		new MenuDetalharOrcamentoUI().executar();
	}
}