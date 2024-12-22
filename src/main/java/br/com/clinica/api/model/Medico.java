package br.com.clinica.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Medico implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_medico",nullable = false)
	private Long idMedico;
	
	@Column(nullable = false,length = 120)
	private String nome;
	
	@Column(nullable = false,length = 120)
	private String sobrenome;
	
	@Column(nullable = false,length = 70)
	private String especialidade;
	
	@Column(nullable = false,length = 15,unique = true)
	private String cpf;
	
	@Column(nullable = false,length = 35)
	private String crm;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name="data_cad")
	private LocalDateTime dataCad;
}
