package br.com.mirante.orcamento.view;

import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.servico.ListarOrcamentoServico;

public class ListarOrcamentosUI implements Funcionalidade {
	
	private ListarOrcamentoServico servico = new ListarOrcamentoServico();
	
	public void executar() {
		var orcamentos = servico.listarOrcamentos();
		
		for (Orcamento orcamento : orcamentos) {
			UIUtils.imprimirOrcamento(orcamento);
		}
		
		new MenuPrincipal().executar();
	}
}
