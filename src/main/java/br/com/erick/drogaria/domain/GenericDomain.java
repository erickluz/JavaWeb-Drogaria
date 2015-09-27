package br.com.erick.drogaria.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")//esconder os warnnings da IDE
@MappedSuperclass
public class GenericDomain implements Serializable {
	@Id												//indicar que um serial
	@GeneratedValue(strategy = GenerationType.AUTO)//indicar que um serial
	private Long codigo;
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}
