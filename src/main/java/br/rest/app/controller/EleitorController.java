package br.rest.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.rest.app.model.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/eleitores")
public class EleitorController {
	
	  @PostMapping
	    public ResponseEntity criar(@RequestBody Eleitor eleitor) {    	    	
	    	if (eleitor.getNome() == "")    	
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado.");
	    	else if (eleitor.getId() == null)    	
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID não informado.");
	    	else
	    		return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso!");
	    }
	  
	  @GetMapping
	    public ResponseEntity listar() {
	    	    	
	    	List<Eleitor> lista = new ArrayList<Eleitor>();
	    	
	    	Eleitor e = new Eleitor();
	    	e.setNome("João");
	    	e.setId(1L);
	    	lista.add(e);
	    	
	    	e = new Eleitor();
	    	e.setNome("Alfredo");
	    	e.setId(2L);
	    	lista.add(e);	
	    	
	    	e = new Eleitor();
	    	e.setNome("Wagner");
	    	e.setId(3L);
	    	lista.add(e);		    	
	    	
	    	return ResponseEntity.status(HttpStatus.OK).body(lista);
	  }
	  
	  @GetMapping(path = "/{id}")
	    public ResponseEntity byId(@PathVariable Long id) {    	  	
	    	
	    	Eleitor e = new Eleitor();
	    	e.setNome("Eduarda");
	    	e.setId(9L);
	    	
	        return ResponseEntity.status(HttpStatus.OK).body(e);
	    } 
	  
	  
	  @PutMapping(path = "/{id}")
	    public ResponseEntity atualizar(@RequestBody Eleitor eleitor, @PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.OK).body(eleitor);
	    }
	  
	   @DeleteMapping(path = "/{id}")
	    public ResponseEntity delete(@PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
	  
	  
}
