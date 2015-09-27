package br.com.erick.drogaria.DAO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.erick.drogaria.dao.ClienteDAO;
import br.com.erick.drogaria.dao.FabricanteDAO;
import br.com.erick.drogaria.dao.FuncionarioDAO;
import br.com.erick.drogaria.dao.ProdutoDAO;
import br.com.erick.drogaria.dao.VendaDAO;
import br.com.erick.drogaria.domain.Cliente;
import br.com.erick.drogaria.domain.Fabricante;
import br.com.erick.drogaria.domain.Funcionario;
import br.com.erick.drogaria.domain.Produto;
import br.com.erick.drogaria.domain.Venda;

public class VendaDAOTest {
	@Test
	//@Ignore
	public void salvar() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = new Venda();
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.Buscar(1L);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.Buscar(1L);
				
		venda.setFuncionario(funcionario);
		venda.setCliente(cliente);
		venda.setHorario(new Date());
		venda.setPrecoTotal(new BigDecimal("150.00"));

		
		vendaDAO.Salvar(venda);

		System.out.println("Produto salvo com sucesso");
	
	}

	@Test
	@Ignore
	public void Listar() {
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> resultado = vendaDAO.Listar();

		System.out.println("Total de Vendas : " + resultado.size());

		for (Venda venda : resultado) {
			System.out.println("Código da venda: " 		+ venda.getCodigo());
			System.out.println("Cliente da venda: " 		+ venda.getCliente());
			System.out.println("Funcionario da venda: " 		+ venda.getFuncionario());
			System.out.println("Horario da venda: " 		+ venda.getHorario());
			System.out.println("Preço total da venda: " 		+ venda.getPrecoTotal());
			
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
			System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getQuantidade() + "-" + produto.getFabricante() + " - " + produto.getPreco());
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
			System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getQuantidade() + "-" + produto.getFabricante() + " - " + produto.getPreco());
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
			System.out.println("Código do produto: " + produto.getCodigo());
			System.out.println("Descrição do produto: " + produto.getDescricao());
			System.out.println("Quantidade disponivel: "+ produto.getQuantidade());
			System.out.println("Fabricante do Produto: " + produto.getFabricante());
			System.out.println("Preço: " + produto.getPreco());
			System.out.println("==================================================================");

			produto.setDescricao("Xarope");
			produto.setFabricante(fabricante);;
			produto.setPreco(new BigDecimal("13.50"));
			produto.setQuantidade(new Short("20"));

			produtoDAO.Editar(produto);
			produto.setFabricante(fabricante);
			System.out.println("Produto a ser Editado:");
			System.out.println("Código do produto: " + produto.getCodigo());
			System.out.println("Descrição do produto: " + produto.getDescricao());
			System.out.println("Quantidade disponivel: "+ produto.getQuantidade());
			System.out.println("Fabricante do Produto: " + produto.getFabricante());
			System.out.println("Preço: " + produto.getPreco());
			System.out.println("==================================================================");


		}
	}
}


