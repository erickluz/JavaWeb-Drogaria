package br.com.erick.drogaria.DAO;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.erick.drogaria.dao.FabricanteDAO;
import br.com.erick.drogaria.dao.ProdutoDAO;
import br.com.erick.drogaria.domain.Fabricante;
import br.com.erick.drogaria.domain.Produto;

public class ProdutoDAOTest {
	@Test
	//@Ignore
	public void salvar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.Buscar(new Long("1"));

		Produto produto = new Produto();
		produto.setDescricao("Dipirona 50mg com 20 Comprimidos");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("13.70"));
		produto.setQuantidade(new Short("7"));

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.Salvar(produto);

		System.out.println("Produto salvo com sucesso");
	}

	@Test
	@Ignore
	public void Listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.Listar();

		System.out.println("Total dede Produtos : " + resultado.size());

		for (Produto produto : resultado) {
			System.out.println("Código do produto: " 		+ produto.getCodigo());
			System.out.println("Descrição do produto: " 	+ produto.getDescricao());
			System.out.println("Quantidade disponivel: "	+ produto.getQuantidade());
			System.out.println("Fabricante do Produto: " 	+ produto.getFabricante());
			System.out.println("Preço: " 					+ produto.getPreco());
		}
	}

	@Test
	@Ignore
	public void Buscar() {
		Long codigo = 2L;

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.Buscar(codigo);
		if (produto == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado");
			System.out.println("Código do produto: " 		+ produto.getCodigo());
			System.out.println("Descrição do produto: " 	+ produto.getDescricao());
			System.out.println("Quantidade disponivel: "	+ produto.getQuantidade());
			System.out.println("Fabricante do Produto: " 	+ produto.getFabricante());
			System.out.println("Preço: " 					+ produto.getPreco());
		}
	}

	@Test
	@Ignore
	public void Excluir() {
		Long codigo = 2L;

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.Buscar(codigo);

		if (produto == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			produtoDAO.Excluir(produto);
			System.out.println("Registro Removido");
			System.out.println("Código do produto: " 		+ produto.getCodigo());
			System.out.println("Descrição do produto: " 	+ produto.getDescricao());
			System.out.println("Quantidade disponivel: "	+ produto.getQuantidade());
			System.out.println("Fabricante do Produto: " 	+ produto.getFabricante());
			System.out.println("Preço: " 					+ produto.getPreco());
		}
	}

	@Test
	@Ignore
	public void Editar() {
		Long codigoProduto = 2L;
		Long codigoFabricante = 2L;

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.Buscar(codigoProduto);

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.Buscar(codigoFabricante);
		
		if (produto == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			
			System.out.println("Produto a ser Editado:");
			System.out.println("Código do produto: " 		+ produto.getCodigo());
			System.out.println("Descrição do produto: " 	+ produto.getDescricao());
			System.out.println("Quantidade disponivel: "	+ produto.getQuantidade());
			System.out.println("Fabricante do Produto: " 	+ produto.getFabricante());
			System.out.println("Preço: " 					+ produto.getPreco());
			System.out.println("==================================================================");

			produto.setDescricao("Xarope");
			produto.setFabricante(fabricante);;
			produto.setPreco(new BigDecimal("13.50"));
			produto.setQuantidade(new Short("20"));

			produtoDAO.Editar(produto);
			produto.setFabricante(fabricante);
			System.out.println("Produto a ser Editado:");
			System.out.println("Código do produto: " 		+ produto.getCodigo());
			System.out.println("Descrição do produto: " 	+ produto.getDescricao());
			System.out.println("Quantidade disponivel: "	+ produto.getQuantidade());
			System.out.println("Fabricante do Produto: " 	+ produto.getFabricante());
			System.out.println("Preço: " 					+ produto.getPreco());
			System.out.println("==================================================================");


		}
	}
}
