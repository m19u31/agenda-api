package com.algaworks.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.crm.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	

}
