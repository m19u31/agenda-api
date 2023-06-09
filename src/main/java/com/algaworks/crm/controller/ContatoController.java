package com.algaworks.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.crm.model.Contato;
import com.algaworks.crm.repository.ContatoRepository;


@RestController
@RequestMapping("/contatos")
public class ContatoController {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@GetMapping
	public List<Contato> listar() {
		return contatoRepository.findAll();		
	}
	
	@PostMapping 
	@ResponseStatus(HttpStatus.CREATED)
	public Contato adicionar(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
	
	
	@DeleteMapping
	public String deletar(@RequestBody Contato contato) {
		contatoRepository.delete(contato);
		return "contato deletado";
	}
	
	@PutMapping
	public String atualizar(@RequestBody Contato contato) {
		if (contato.getId() != null) {
			contatoRepository.save(contato);
			return "contato salvo";
		}
		else {
			
			return "contato não encontrado";
		}
		
	}
	

}
