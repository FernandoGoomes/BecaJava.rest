package br.rest.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.rest.app.model.*;


import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/zonas")
public class ZonaEleitoralController {
	
	  @PostMapping
	    public ResponseEntity criar(@RequestBody ZonaEleitoral zonaEleitoral) {    	    	
	    	if (zonaEleitoral.getNome() == "")    	
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado.");
	    	else if (zonaEleitoral.getId() == null)    	
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID não informado.");
	    	else
	    		return ResponseEntity.status(HttpStatus.CREATED).body("Zona Eleitoral criada com sucesso!");
	    }
	  
	  @GetMapping
	    public ResponseEntity listar() {
	    	    	
	    	List<ZonaEleitoral> lista = new ArrayList<ZonaEleitoral>();
	    	
	    	ZonaEleitoral z = new ZonaEleitoral();
	    	z.setNome("Capão Redondo");
	    	z.setId(1L);
	    	lista.add(z);
	    	
	    	z = new ZonaEleitoral();
	    	z.setNome("Morumbi");
	    	z.setId(2L);
	    	lista.add(z);	
	    	
	    	z = new ZonaEleitoral();
	    	z.setNome("Parque Santo Antonio");
	    	z.setId(3L);
	    	lista.add(z);		    	
	    	
	    	return ResponseEntity.status(HttpStatus.OK).body(lista);
	  }
	  
	  @GetMapping(path = "/{id}")
	    public ResponseEntity byId(@PathVariable Long id) {    	  	
	    	
		  ZonaEleitoral z = new ZonaEleitoral();
	    	z.setNome("Capão Redondo");
	    	z.setId(1L);
	    	
	        return ResponseEntity.status(HttpStatus.OK).body(z);
	    } 
	  
	  
	  @PutMapping(path = "/{id}")
	    public ResponseEntity atualizar(@RequestBody ZonaEleitoral zonaEleitoral, @PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.OK).body(zonaEleitoral);
	    }
	  
	   @DeleteMapping(path = "/{id}")
	    public ResponseEntity delete(@PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
	  
	  
}
