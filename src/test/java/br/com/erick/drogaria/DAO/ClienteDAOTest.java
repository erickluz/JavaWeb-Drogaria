package br.com.erick.drogaria.DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.erick.drogaria.dao.ClienteDAO;
import br.com.erick.drogaria.dao.PessoaDAO;
import br.com.erick.drogaria.domain.Cliente;
import br.com.erick.drogaria.domain.Pessoa;

public class ClienteDAOTest {
	@Test
	//@Ignore
	public void salvar() throws ParseException {
		
		PessoaDAO pessoaDAO= new PessoaDAO();
		Pessoa pessoa = pessoaDAO.Buscar(1L);
			
		Cliente cliente = new Cliente();
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2015"));
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);
		
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.Salvar(cliente);
		
		System.out.println("Cliente salvo com sucesso");
		
	}
	
		

	@Test
	@Ignore
	public void Listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.Listar();

		System.out.println("Total de Clientes : " + resultado.size());

		for (Cliente cliente : resultado) {
			System.out.println("Codigo "			+ cliente.getCodigo());
			System.out.println("Data de cadastro: "	+ cliente.getDataCadastro());
			System.out.println("Status de compra: "	+ cliente.getLiberado());
			System.out.println("Pessoa: "			+ cliente.getPessoa());
			
		}}

	@Test
	@Ignore
	public void Buscar() {
		Long codigo = 2L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.Buscar(codigo);
		if (cliente == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Codigo "			+ cliente.getCodigo());
			System.out.println("Data de cadastro: "	+ cliente.getDataCadastro());
			System.out.println("Status de compra: "	+ cliente.getLiberado());
			System.out.println("Pessoa: "			+ cliente.getPessoa());
		}
	}

	@Test
	@Ignore
	public void Excluir() {
		Long codigo = 2L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.Buscar(codigo);
		if (cliente == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			clienteDAO.Excluir(cliente);
			System.out.println("Registro Removido");
			System.out.println("Codigo "			+ cliente.getCodigo());
			System.out.println("Data de cadastro: "	+ cliente.getDataCadastro());
			System.out.println("Status de compra: "	+ cliente.getLiberado());
			System.out.println("Pessoa: "			+ cliente.getPessoa());
		}
	}

	@Test
	@Ignore
	public void Editar() {
		Long codigoCliente = 2L;
		Long codigoPessoa = 2L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.Buscar(codigoCliente);

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.Buscar(codigoPessoa);
		
		if (cliente == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			clienteDAO.Excluir(cliente);
			System.out.println("Registro Removido");
			System.out.println("Codigo "			+ cliente.getCodigo());
			System.out.println("Data de cadastro: "	+ cliente.getDataCadastro());
			System.out.println("Status de compra: "	+ cliente.getLiberado());
			System.out.println("Pessoa: "			+ cliente.getPessoa());
			System.out.println("==================================================================");

			cliente.setDataCadastro(new Date());
			cliente.setLiberado(true);
			cliente.setPessoa(pessoa);

			clienteDAO.Editar(cliente);
			cliente.setPessoa(pessoa);
			clienteDAO.Excluir(cliente);
			System.out.println("Registro Removido");
			System.out.println("Codigo "			+ cliente.getCodigo());
			System.out.println("Data de cadastro: "	+ cliente.getDataCadastro());
			System.out.println("Status de compra: "	+ cliente.getLiberado());
			System.out.println("Pessoa: "			+ cliente.getPessoa());
			System.out.println("==================================================================");
			

		}
	}
}

