package br.com.mirante.orcamento.servico;

import java.util.List;

import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.servico.ListarOrcamentoServico;
import br.com.mirante.orcamento.repositorio.OrcamentoRepository;
import br.com.mirante.orcamento.repositorio.OrcamentoRepositoryJDBC;

public class ListarOrcamentoServico {
	
	private OrcamentoRepository repository = new OrcamentoRepositoryJDBC();
	
	public List<Orcamento> listarOrcamentos(){
		
		return repository.listar();
	}
}
