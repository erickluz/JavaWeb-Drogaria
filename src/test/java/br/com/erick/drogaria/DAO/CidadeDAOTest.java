package br.com.erick.drogaria.DAO;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.erick.drogaria.dao.CidadeDAO;
import br.com.erick.drogaria.dao.EstadoDAO;
import br.com.erick.drogaria.domain.Cidade;
import br.com.erick.drogaria.domain.Estado;

public class CidadeDAOTest {
	@Test
	//@Ignore
	public void Salvar() {
		Long codigoEstado = 1L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.Buscar(codigoEstado);

		Cidade cidade = new Cidade();
		cidade.setNome("Rio Grande do Sul");
		cidade.setEstado(estado);

		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.Salvar(cidade);
	}

	@Test
	@Ignore
	public void Listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.Listar();

		System.out.println("Total de cidades: " + resultado.size());

		for (Cidade cidade : resultado) {
			System.out.println("Codigo:"	+ cidade.getCodigo());
			System.out.println("Nome:"		+ cidade.getNome());
			System.out.println("Estado:"	+ cidade.getEstado());
		

		}
	}

	@Test
	@Ignore
	public void Buscar() {
		Long codigo = 2L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.Buscar(codigo);
		if (cidade == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado");
			System.out.println("Codigo:"	+ cidade.getCodigo());
			System.out.println("Nome:"		+ cidade.getNome());
			System.out.println("Estado:"	+ cidade.getEstado());
		}
	}

	@Test
	@Ignore
	public void Excluir() {
		Long codigo = 2L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.Buscar(codigo);

		if (cidade == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			cidadeDAO.Excluir(cidade);
			System.out.println("Registro Removido");
			System.out.println("Codigo:"	+ cidade.getCodigo());
			System.out.println("Nome:"		+ cidade.getNome());
			System.out.println("Estado:"	+ cidade.getEstado());
		}
	}

	@Test
	@Ignore
	public void Editar() {
		Long codigoCidade = 2L;
		Long codigoEstado = 2L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.Buscar(codigoEstado);

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.Buscar(codigoCidade);

		if (cidade == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Cidade a ser Editada:");
			System.out.println("Código da Cidade"	+ cidade.getCodigo());
			System.out.println("Nome da Cidade"		+ cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " 	+ cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " 	+ cidade.getEstado().getNome());
			System.out.println("==================================================================");

			cidade.setNome("São Paulo");

			cidadeDAO.Editar(cidade);
			cidade.setEstado(estado);

			System.out.println("Cidade a ser Editada:");
			System.out.println("Código da Cidade" 	+ cidade.getCodigo());
			System.out.println("Nome da Cidade" 	+ cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " 	+ cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " 	+ cidade.getEstado().getNome());
			System.out.println("==================================================================");

		}

	}
}