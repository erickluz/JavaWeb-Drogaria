package br.com.erick.drogaria.DAO;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.erick.drogaria.dao.FabricanteDAO;
import br.com.erick.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	@Ignore
	public void Salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Fabrica remedios");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.Salvar(fabricante);

	}

	
	
	@Test
	@Ignore
	public void Listar() {
		FabricanteDAO FabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = FabricanteDAO.Listar();

		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Fabricante fabricante : resultado) {
			System.out.println("Codigo: "	+ fabricante.getCodigo());
			System.out.println("Descrição: "	+ fabricante.getDescricao());
		}

	}

	@Test
	@Ignore
	public void Buscar() {
		Long codigo = 2L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.Buscar(codigo);
		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado");
			System.out.println("Codigo: "	+ fabricante.getCodigo());
			System.out.println("Descrição: "	+ fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void Excluir() {
		Long codigo = 2L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.Buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			fabricanteDAO.Excluir(fabricante);
			System.out.println("Registro removido:");
			System.out.println("Codigo: "	+ fabricante.getCodigo());
			System.out.println("Descrição: "	+ fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void Editar() {
		Long codigo = 3L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.Buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro editado - Antes:");
			System.out.println("Codigo: "	+ fabricante.getCodigo());
			System.out.println("Descrição: "	+ fabricante.getDescricao());
			
			fabricante.setDescricao("Fabricante de shampoo");

			System.out.println("Registro editado - Depois:");
			System.out.println("Codigo: "	+ fabricante.getCodigo());
			System.out.println("Descrição: "	+ fabricante.getDescricao());

		}
	}
	@Test
	@Ignore
	public void Merge() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Fabricante A");
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.Salvar(fabricante);

	}
	
	
}