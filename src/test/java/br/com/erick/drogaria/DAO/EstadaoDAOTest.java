package br.com.erick.drogaria.DAO;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.erick.drogaria.dao.EstadoDAO;
import br.com.erick.drogaria.domain.Estado;

public class EstadaoDAOTest {
	@Test
	//@Ignore
	public void Salvar() {
		Estado estado = new Estado();
		estado.setNome("Rio Grande do Sul");
		estado.setSigla("RS");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.Salvar(estado);
	}

	@Test
	@Ignore
	public void Listar() {

		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.Listar();

		System.out.println("Total de estados: \n" + resultado.size());

		for (Estado estado : resultado) {
			System.out.println("Codigo:" 	+ estado.getCodigo());
			System.out.println("Nome:" 		+ estado.getNome());
			System.out.println("Sigla:" 	+ estado.getSigla());
		}
	}

	@Test
	@Ignore
	public void Buscar() {
		Long codigo = 2L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.Buscar(codigo);
		if (estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Codigo:" 	+ estado.getCodigo());
			System.out.println("Nome:" 		+ estado.getNome());
			System.out.println("Sigla:" 	+ estado.getSigla());
		}
	}

	@Test
	@Ignore
	public void Excluir() {
		Long codigo = 1L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.Buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			estadoDAO.Excluir(estado);
			System.out.println("Registro removido:");
			System.out.println("Codigo:" 	+ estado.getCodigo());
			System.out.println("Nome:" 		+ estado.getNome());
			System.out.println("Sigla:" 	+ estado.getSigla());
		}
	}

	@Test
	@Ignore
	public void Editar() {
		Long codigo = 1L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.Buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro editado - Antes:");
			System.out.println("Codigo:" 	+ estado.getCodigo());
			System.out.println("Nome:" 		+ estado.getNome());
			System.out.println("Sigla:" 	+ estado.getSigla());
			
			estado.setNome("Santa Catarina");
			estado.setSigla("SC");
			estadoDAO.Editar(estado);

			System.out.println("Registro editado - Depois:");
			System.out.println("Codigo:" 	+ estado.getCodigo());
			System.out.println("Nome:" 		+ estado.getNome());
			System.out.println("Sigla:" 	+ estado.getSigla());
			
		}
	}
}