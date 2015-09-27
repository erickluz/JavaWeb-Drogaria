package br.com.erick.drogaria.DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.erick.drogaria.dao.FuncionarioDAO;
import br.com.erick.drogaria.dao.PessoaDAO;
import br.com.erick.drogaria.domain.Funcionario;
import br.com.erick.drogaria.domain.Pessoa;

public class FuncionarioDAOTest {
	@Test
	//@Ignore
	public void salvar() throws ParseException {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = new Funcionario();
		
		PessoaDAO pessoaDAO= new PessoaDAO();
		Pessoa pessoa = pessoaDAO.Buscar(1L);
		
		funcionario.setCarteiraTrabalho("400400900");
		funcionario.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("15/09/2015"));
		funcionario.setPessoa(pessoa);
		
		funcionarioDAO.Salvar(funcionario);

		System.out.println("Funcionario salvo com sucesso");
	}

	@Test
	@Ignore
	public void Listar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> resultado = funcionarioDAO.Listar();

		System.out.println("Total de funcionarios : " + resultado.size());

		for (Funcionario funcionario : resultado) {
			System.out.println("Codigo: "	+ funcionario.getCodigo());
			System.out.println("Descrição: "	+ funcionario.getCarteiraTrabalho());
			System.out.println("Descrição: "	+ funcionario.getDataAdmissao());
			System.out.println("Descrição: "	+ funcionario.getPessoa());
		}
	}

	@Test
	@Ignore
	public void Buscar() {
		Long codigo = 2L;

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.Buscar(codigo);
		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado");
			System.out.println("Codigo: "	+ funcionario.getCodigo());
			System.out.println("Descrição: "	+ funcionario.getCarteiraTrabalho());
			System.out.println("Descrição: "	+ funcionario.getDataAdmissao());
			System.out.println("Descrição: "	+ funcionario.getPessoa());
		}
	}

	@Test
	@Ignore
	public void Excluir() {
		Long codigo = 2L;

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.Buscar(codigo);
		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			funcionarioDAO.Excluir(funcionario);
			System.out.println("Registro Removido: ");
			System.out.println("Codigo: "	+ funcionario.getCodigo());
			System.out.println("Descrição: "	+ funcionario.getCarteiraTrabalho());
			System.out.println("Descrição: "	+ funcionario.getDataAdmissao());
			System.out.println("Descrição: "	+ funcionario.getPessoa());
		}
	}

	@Test
	@Ignore
	public void Editar() throws ParseException {
		Long codigoFuncionario= 2L;
		Long codigoPessoa= 2L;

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.Buscar(codigoFuncionario);
		
		PessoaDAO pessoaDAO= new PessoaDAO();
		Pessoa pessoa = pessoaDAO.Buscar(codigoPessoa);

		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			
			System.out.println("Funcionario a ser Editado:");
			System.out.println("Codigo: "	+ funcionario.getCodigo());
			System.out.println("Descrição: "	+ funcionario.getCarteiraTrabalho());
			System.out.println("Descrição: "	+ funcionario.getDataAdmissao());
			System.out.println("Descrição: "	+ funcionario.getPessoa());
			System.out.println("==================================================================");

			funcionario.setCarteiraTrabalho("40044232300900");
			funcionario.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("16/09/2015"));
			funcionario.setPessoa(pessoa);

			funcionarioDAO.Editar(funcionario);
			
			System.out.println("Funcionario editado:");
			System.out.println("Codigo: "	+ funcionario.getCodigo());
			System.out.println("Descrição: "	+ funcionario.getCarteiraTrabalho());
			System.out.println("Descrição: "	+ funcionario.getDataAdmissao());
			System.out.println("Descrição: "	+ funcionario.getPessoa());
			System.out.println("==================================================================");


		}
	}
}

