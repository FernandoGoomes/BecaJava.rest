package br.rest.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.rest.app.model.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {
	
	  @PostMapping
	    public ResponseEntity criar(@RequestBody Municipio municipio) {    	    	
	    	if (municipio.getNome() == "")    	
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado.");
	    	else if (municipio.getId() == null)    	
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID não informado.");
	    	else if (municipio.getPopulacao() == 0)    	
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("População não informado.");
	    	else
	    		return ResponseEntity.status(HttpStatus.CREATED).body("Municipio criado com sucesso!");
	    }
	  
	  @GetMapping
	    public ResponseEntity listar() {
	    	    	
	    	List<Municipio> lista = new ArrayList<Municipio>();
	    	
	    	Municipio m = new Municipio();
	    	m.setNome("São Paulo");
	    	m.setId(1L);
	    	m.setPopulacao(6400000);
	    	lista.add(m);
	    	
	    	m = new Municipio();
	    	m.setNome("Salvador");
	    	m.setId(2L);
	    	m.setPopulacao(4400000);
	    	lista.add(m);	
	    	
	    	m = new Municipio();
	    	m.setNome("Florianopolis");
	    	m.setId(3L);
	    	m.setPopulacao(1400000);
	    	lista.add(m);		    	
	    	
	    	return ResponseEntity.status(HttpStatus.OK).body(lista);
	  }
	  
	  @GetMapping(path = "/{id}")
	    public ResponseEntity byId(@PathVariable Long id) {    	  	
	    	
	    	Municipio m = new Municipio();
	    	m.setNome("São Paulo");
	    	m.setId(1L);
	    	m.setPopulacao(6400000);
	    	
	        return ResponseEntity.status(HttpStatus.OK).body(m);
	    } 
	  
	  
	  @PutMapping(path = "/{id}")
	    public ResponseEntity atualizar(@RequestBody Municipio municipio, @PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.OK).body(municipio);
	    }
	  
	   @DeleteMapping(path = "/{id}")
	    public ResponseEntity deletar(@PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
	
	
}
	


