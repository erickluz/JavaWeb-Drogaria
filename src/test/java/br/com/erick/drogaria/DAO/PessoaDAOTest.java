package br.com.erick.drogaria.DAO;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.erick.drogaria.dao.CidadeDAO;
import br.com.erick.drogaria.dao.PessoaDAO;
import br.com.erick.drogaria.domain.Cidade;
import br.com.erick.drogaria.domain.Pessoa;

public class PessoaDAOTest {
	@Test
	//@Ignore
	public void salvar() {
		CidadeDAO cidadeDAO =   new CidadeDAO();
		Cidade cidade = cidadeDAO.Buscar(1L);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = new Pessoa();
		
		pessoa.setBairro("aaa");
		pessoa.setCelular("999");
		pessoa.setCep("1111");
		pessoa.setCidade(cidade);
		pessoa.setComplemento("apar");
		pessoa.setCpf("3123");
		pessoa.setEmail("leo");
		pessoa.setNome("Leonardo");
		pessoa.setNumero(new Short("0002"));
		pessoa.setRg("21321");
		pessoa.setRua("sdas");
		pessoa.setTelefone("213");
		
		pessoaDAO.Salvar(pessoa);
		
		
		System.out.println("Pessoa salva com sucesso");
	}

	@Test
	@Ignore
	public void Listar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.Listar();

		System.out.println("Total de Pessoas : " + resultado.size());

		for (Pessoa pessoa : resultado) {
			System.out.println("Codigo "	+ pessoa.getCodigo());
			System.out.println("Celular: "	+ pessoa.getCelular());
			System.out.println("CEP: "		+ pessoa.getCep());
			System.out.println("Complemento: "+ pessoa.getComplemento());
			System.out.println("CPF "		+ pessoa.getCpf());
			System.out.println("email: "+ pessoa.getEmail());
			System.out.println("Nome: "+ pessoa.getNome());
			System.out.println("RG: "+ pessoa.getRg());
			System.out.println("Rua "+ pessoa.getRua());
			System.out.println("Telefone "+ pessoa.getTelefone());
			System.out.println("Numero da casa: "+ pessoa.getNumero());
			System.out.println("Cidade: "+ pessoa.getCidade());
			

		}
	}

	@Test
	@Ignore
	public void Buscar() {
		Long codigo = 2L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.Buscar(codigo);
		if (pessoa == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado");
			System.out.println("Codigo "+ pessoa.getCodigo());
			System.out.println("Celular: "+ pessoa.getCelular());
			System.out.println("CEP: "+ pessoa.getCep());
			System.out.println("Complemento: "+ pessoa.getComplemento());
			System.out.println("CPF "+ pessoa.getCpf());
			System.out.println("email: "+ pessoa.getEmail());
			System.out.println("Nome: "+ pessoa.getNome());
			System.out.println("RG: "+ pessoa.getRg());
			System.out.println("Rua "+ pessoa.getRua());
			System.out.println("Telefone "+ pessoa.getTelefone());
			System.out.println("Numero da casa: "+ pessoa.getNumero());
			System.out.println("Cidade: "+ pessoa.getCidade());
		}
	}

	@Test
	@Ignore
	public void Excluir() {
		Long codigo = 2L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.Buscar(codigo);

		if (pessoa == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			pessoaDAO.Excluir(pessoa);
			System.out.println("Registro Removido");
			System.out.println("Codigo "+ pessoa.getCodigo());
			System.out.println("Celular: "+ pessoa.getCelular());
			System.out.println("CEP: "+ pessoa.getCep());
			System.out.println("Complemento: "+ pessoa.getComplemento());
			System.out.println("CPF "+ pessoa.getCpf());
			System.out.println("email: "+ pessoa.getEmail());
			System.out.println("Nome: "+ pessoa.getNome());
			System.out.println("RG: "+ pessoa.getRg());
			System.out.println("Rua "+ pessoa.getRua());
			System.out.println("Telefone "+ pessoa.getTelefone());
			System.out.println("Numero da casa: "+ pessoa.getNumero());
			System.out.println("Cidade: "+ pessoa.getCidade());
		}
	}

	@Test
	@Ignore
	public void Editar() {
		Long codigoCidade = 1L;
		Pessoa pessoa = new Pessoa();
		
		System.out.println("Pessoa a ser Editada:");
		System.out.println("Codigo "+ pessoa.getCodigo());
		System.out.println("Celular: "+ pessoa.getCelular());
		System.out.println("CEP: "+ pessoa.getCep());
		System.out.println("Complemento: "+ pessoa.getComplemento());
		System.out.println("CPF "+ pessoa.getCpf());
		System.out.println("email: "+ pessoa.getEmail());
		System.out.println("Nome: "+ pessoa.getNome());
		System.out.println("RG: "+ pessoa.getRg());
		System.out.println("Rua "+ pessoa.getRua());
		System.out.println("Telefone "+ pessoa.getTelefone());
		System.out.println("Numero da casa: "+ pessoa.getNumero());
		System.out.println("Cidade: "+ pessoa.getCidade());
		System.out.println("==================================================================");
		
		pessoa.setBairro		("Helenaqqqqni");
		pessoa.setCelular		("99992228897777");;
		pessoa.setCep			("19444000");;
		pessoa.setComplemento	("Apadddnto");;
		pessoa.setCpf			("111664111");
		pessoa.setEmail			("leonafffeonardo");
		pessoa.setNome			("Lucfdsrique");
		pessoa.setNumero		(new Short("202440"));
		pessoa.setRg			("464446644");
		pessoa.setRua			("Duquegggias");
		pessoa.setTelefone		("33255435");
		pessoa.setNome			("Rio Grggg Sul");
		
		//Chama classe cidade
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.Buscar(codigoCidade);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.Editar(pessoa);
		pessoa.setCidade(cidade);
		
		System.out.println("Pessoa a ser Editada:");
		System.out.println("Codigo "+ pessoa.getCodigo());
		System.out.println("Celular: "+ pessoa.getCelular());
		System.out.println("CEP: "+ pessoa.getCep());
		System.out.println("Complemento: "+ pessoa.getComplemento());
		System.out.println("CPF "+ pessoa.getCpf());
		System.out.println("email: "+ pessoa.getEmail());
		System.out.println("Nome: "+ pessoa.getNome());
		System.out.println("RG: "+ pessoa.getRg());
		System.out.println("Rua "+ pessoa.getRua());
		System.out.println("Telefone "+ pessoa.getTelefone());
		System.out.println("Numero da casa: "+ pessoa.getNumero());
		System.out.println("Cidade: "+ pessoa.getCidade());
		System.out.println("==================================================================");

	}
}