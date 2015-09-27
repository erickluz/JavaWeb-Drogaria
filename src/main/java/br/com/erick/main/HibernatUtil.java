package br.com.erick.main;

import org.hibernate.Session;

import br.com.erick.drogaria.util.HibernateUtil;

public class HibernatUtil {
	public static void main(String[] args) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}
}
