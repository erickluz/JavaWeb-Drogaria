package br.com.erick.drogaria.DAO;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.erick.drogaria.dao.PessoaDAO;
import br.com.erick.drogaria.dao.UsuarioDAO;
import br.com.erick.drogaria.domain.Pessoa;
import br.com.erick.drogaria.domain.Usuario;

public class UsuarioDAOTest {
	@Test
	//@Ignore
	public void salvar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.Buscar(1L);
		
		System.out.println("Pessoa Encontrada");
		System.out.println("Nome: " + pessoa.getNome());
		
		
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setPessoa(pessoa);
		usuario.setSenha("q1w2e3r4");
		usuario.setTipo('A');
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.Salvar(usuario);
		
		System.out.println("Usuario salvo com sucesso");
	}

	@Test
	@Ignore
	public void Listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.Listar();

		System.out.println("Total dede Produtos : " + resultado.size());

		for (Usuario usuario : resultado) {
			System.out.println("Pessoa Encontrada");
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("Codigo: " + usuario.getCodigo());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Ativo: " + usuario.getAtivo());
			System.out.println("Pessoa: " + usuario.getPessoa());
		}
	}

	@Test
	@Ignore
	public void Buscar() {
		Long codigo = 1L;

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.Buscar(codigo);
		if (usuario == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado");
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("Codigo: " + usuario.getCodigo());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Ativo: " + usuario.getAtivo());
			System.out.println("Pessoa: " + usuario.getPessoa());
		}
	}

	@Test
	@Ignore
	public void Excluir() {
		Long codigo = 1L;

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.Buscar(codigo);
		if (usuario == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			usuarioDAO.Excluir(usuario);
			System.out.println("Registro Removido");
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("Codigo: " + usuario.getCodigo());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Ativo: " + usuario.getAtivo());
			System.out.println("Pessoa: " + usuario.getPessoa());
		}
	}

	@Test
	@Ignore
	public void Editar() {
		Long codigoUsuario = 1L;
		Long codigoPessoa = 1L;

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.Buscar(codigoUsuario);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.Buscar(codigoPessoa);
		
		if (usuario == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			
			System.out.println("Produto a ser Editado:");
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("Codigo: " + usuario.getCodigo());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Ativo: " + usuario.getAtivo());
			System.out.println("Pessoa: " + usuario.getPessoa());
			System.out.println("==================================================================");

			usuario.setAtivo(true);
			usuario.setPessoa(pessoa);
			usuario.setSenha("q1w2e3r4t5");
			usuario.setTipo('B');

			usuarioDAO.Editar(usuario);
			usuario.setPessoa(pessoa);
			System.out.println("Produto a ser Editado:");
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("Codigo: " + usuario.getCodigo());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Ativo: " + usuario.getAtivo());
			System.out.println("Pessoa: " + usuario.getPessoa());
			System.out.println("==================================================================");


		}
	}
}

