package br.com.erick.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.erick.drogaria.dao.EstadoDAO;
import br.com.erick.drogaria.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	
	private Estado estado;
	private List<Estado> estados;

	public void setEstado(Estado estado){
		this.estado = estado;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void novo(){
		estado = new Estado();
	}
	
	public List<Estado> getEstados() {
		return estados;
	}
	
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	public void salvar(){
		try{
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.Salvar(estado);
			Messages.addGlobalInfo("Estado Salvo com sucesso!!");
			listar();
		}catch(RuntimeException erro){
			Messages.addGlobalError("Erro ao cadastrar o Estado");
			erro.printStackTrace();
		}
		
		
		//Messages.addGlobalInfo("Estado: " + estado.getNome() + "Sigla: " + estado.getSigla());
		
	}

	@PostConstruct
	public void listar(){
		try{
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.Listar();			
		}catch(RuntimeException erro){
			Messages.addGlobalError("Erro ao listar o Estado");
			erro.printStackTrace();
		}
	}
}
