package br.com.mirante.orcamento.servico;

import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.repositorio.*;

public class DetalharOrcamentoServico {
	private OrcamentoRepository repositorio = new OrcamentoRepositoryJDBC();

	public Orcamento recuperar(int id) {
		return repositorio.recuperar(id);
		
	}

	

}
