package br.com.erick.drogaria.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.erick.drogaria.util.HibernateUtil;

public class GenericDAO<Entidade> {
	//Foi feito uma api para reparar um possivel erro na hora de listar, pois a classe daogeneric não consegue identificar o tipo da classe
	private Class<Entidade>classe;
	@SuppressWarnings("unchecked")
	public GenericDAO() {//                                  //classe atual //pega o supertipo generico
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				//pega somente a posição zero
				.getActualTypeArguments()[0];
	}
	//=======================================
	
	
	public void Salvar(Entidade entidade){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		}catch(RuntimeException erro){
			if(transacao != null){
				transacao.rollback();
			}
			throw erro;
		}finally{
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> Listar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try{
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
		}catch(RuntimeException erro){
			throw erro ;
		}finally{
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Entidade Buscar(Long codigo){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try{
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;
		}catch(RuntimeException erro){
			throw erro ;
		}finally{
			sessao.close();
		}
	}
	
	public void Excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	public void Editar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	public void Merge(Entidade entidade){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.merge(entidade);
			transacao.commit();
		}catch(RuntimeException erro){
			if(transacao != null){
				transacao.rollback();
			}
			throw erro;
		}finally{
			sessao.close();
		}
	}
}
	

