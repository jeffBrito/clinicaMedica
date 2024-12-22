package br.com.clinica.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinica.api.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
