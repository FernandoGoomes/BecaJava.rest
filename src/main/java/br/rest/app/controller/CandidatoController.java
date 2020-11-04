package br.rest.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.rest.app.model.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {
	
	  @PostMapping
	    public ResponseEntity criar(@RequestBody Candidato candidato) {    	    	
	    	if (candidato.getNome() == "")    	
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado.");
	    	else if (candidato.getId() == null)    	
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID não informado.");
	    	else if (candidato.getNumero() == "")    	
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Numero não informado.");
	    	else if (candidato.getTipo() == "")    	
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo não informado.");
	    	else
	    		return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso!");
	    }
	  
	  @GetMapping
	    public ResponseEntity listar() {
	    	    	
	    	List<Candidato> lista = new ArrayList<Candidato>();
	    	
	    	Candidato c = new Candidato();
	    	c.setNome("José");
	    	c.setId(1L);
	    	c.setNumero("2245");
	    	c.setTipo("Presidente");
	    	lista.add(c);
	    	
	    	c = new Candidato();
	    	c.setNome("Jair");
	    	c.setId(2L);
	    	c.setNumero("2425");
	    	c.setTipo("Presidente");
	    	lista.add(c);	
	    	
	    	c = new Candidato();
	    	c.setNome("Trump");
	    	c.setId(3L);
	    	c.setNumero("2353");
	    	c.setTipo("Presidente");
	    	lista.add(c);		    	
	    	
	    	return ResponseEntity.status(HttpStatus.OK).body(lista);
	  }
	  
	  @GetMapping(path = "/{id}")
	    public ResponseEntity byId(@PathVariable Long id) {    	  	
	    	
	    	Candidato c = new Candidato();
	    	c.setNome("José");
	    	c.setId(1L);
	    	c.setNumero("2245");
	    	c.setTipo("Presidente");
	    	
	        return ResponseEntity.status(HttpStatus.OK).body(c);
	    } 
	  
	  
	  @PutMapping(path = "/{id}")
	    public ResponseEntity atualizar(@RequestBody Candidato candidato, @PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.OK).body(candidato);
	    }
	  
	   @DeleteMapping(path = "/{id}")
	    public ResponseEntity deletar(@PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
	
	
}
