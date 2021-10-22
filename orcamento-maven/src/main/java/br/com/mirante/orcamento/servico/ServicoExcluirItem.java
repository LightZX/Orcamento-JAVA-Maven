package br.com.mirante.orcamento.servico;

import br.com.mirante.orcamento.repositorio.ItemRepository;
import br.com.mirante.orcamento.repositorio.ItemRepositoryJDBC;

public class ServicoExcluirItem {
	
	private ItemRepository repositorio = new ItemRepositoryJDBC();
	
	public void excluirItem(Integer codigoItem) {
		repositorio.excluir(codigoItem);
	}
}
