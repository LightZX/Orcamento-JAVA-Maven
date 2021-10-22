package br.com.mirante.orcamento.servico;

import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.repositorio.OrcamentoRepository;
import br.com.mirante.orcamento.repositorio.OrcamentoRepositoryJDBC;

public class CadastraOrcamentoServico {
	
	private OrcamentoRepository repositorio = new OrcamentoRepositoryJDBC();
	
	public void cadastrar(Orcamento orcamento) {
		int maiorId = repositorio.obterMaiorId();
		orcamento.setId(maiorId + 1);
		repositorio.salvar(orcamento);
	}
}
