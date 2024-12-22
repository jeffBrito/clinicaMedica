package br.com.clinica.api.model;

import java.io.Serializable;
import java.time.LocalDate;
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
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente",nullable = false)
	private Long idCliente;
	
	@Column(nullable = false,length = 120)
	private String nome;
	
	@Column(nullable = false,length = 120)
	private String sobrenome;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private LocalDate dataNasc;
	
	@Column(nullable = false,length = 14,unique = true)
	private String cpf;
	
	@Column(nullable = true,length = 15)
	private String telefone;
	
	@Column(nullable = false,length = 120)
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private LocalDateTime dataCad;
	
}
