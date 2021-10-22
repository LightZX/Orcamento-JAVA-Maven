package br.com.mirante.orcamento.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.mirante.orcamento.domain.ItemOrcamento;
import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.servico.CadastraOrcamentoServico;

public class CadastrarOrcamentoUI implements Funcionalidade {
	
	private CadastraOrcamentoServico servico = new CadastraOrcamentoServico();
	Scanner sc = new Scanner(System.in);
	
	public void executar() {
		
		System.out.println("=====================");
		System.out.println("Descreva o orçamento:");
		var descricao = sc.nextLine();
		
		System.out.println("Digite o mês:");
		var mes = sc.nextInt();
		
		System.out.println("Digite o ano:");
		var ano = sc.nextInt();
		
		System.out.println("Digite o Valor Total do Orçamento:");
		var valorTotal = sc.nextFloat();
		
		sc.nextLine();
		
		System.out.println("Informe um item de orçamento:");
		var item = sc.nextLine();

		List<String> itens = new ArrayList<>();
		itens.add(item);
		
		System.out.println("Deseja incluir um novo item? [S] / [N]");
		String novoItem = sc.nextLine();
		while(novoItem.equalsIgnoreCase("S")) {
			System.out.println("Informe um item de orçamento:");
			item = sc.nextLine();
			itens.add(item);
			System.out.println("Deseja incluir um novo item? [S] / [N]");
			novoItem = sc.nextLine();
		}
		
		List<ItemOrcamento> itensOrcamento = itens.stream().map(this::converter).toList();
		
		var orcamento = new Orcamento(
			descricao, mes, ano, valorTotal, itensOrcamento
		);
		
		servico.cadastrar(orcamento);
		new MenuPrincipal().executar();
	}
	
	private ItemOrcamento converter(String item) {
		String[] atributos = item.split(";");
		String origem = atributos[0];
		String codigo = atributos[1];
		String descricao = atributos[2];
		float valorUnitario = Float.parseFloat(atributos[3]);
		String unidade = atributos[4];
		float quantidade = Float.parseFloat(atributos[5]);
		float valorTotalInformado = Float.parseFloat(atributos[6]);
		
		return new ItemOrcamento(
			origem, codigo, descricao, valorUnitario, unidade, quantidade, valorTotalInformado
		);
	}

}