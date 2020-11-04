package br.rest.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.rest.app.model.Voto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/votos")
public class VotoController { 

    @PostMapping
    public ResponseEntity criar(@RequestBody Voto voto) {    	    	
    	if (voto.getId()==null)    	
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id não informado.");
    	else if (voto.getCandidatoId()==null)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Candidato nao informado.");
    	else if (voto.getEleitorId()==null)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Eleitor não informado.");
    	else if (voto.getZonaId()==null)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Zona não informada.");
    	else
    		return ResponseEntity.status(HttpStatus.CREATED).body("Voto criado com sucesso!");
    }

    @GetMapping
    public ResponseEntity listar() {
    	    	
    	List<Voto> lista = new ArrayList<Voto>();
    	
    	Voto v = new Voto();
    	v.setId(2L);
    	v.setCandidatoId(4L);
    	v.setEleitorId(5L);
    	v.setZonaId(2L);
    	lista.add(v);
    	
    	v = new Voto();
    	v.setId(6L);
    	v.setCandidatoId(12L);
    	v.setEleitorId(7L);
    	v.setZonaId(9L);
    	lista.add(v);
    	
    	v = new Voto();
    	v.setId(15L);
    	v.setCandidatoId(6L);
    	v.setEleitorId(8L);
    	v.setZonaId(9L);
    	lista.add(v);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity byId(@PathVariable Long id) {    	  	
    	
    	Voto v = new Voto();
    	v.setId(7L);
    	v.setCandidatoId(4L);
    	v.setEleitorId(6L);
    	v.setZonaId(1L);
    
        return ResponseEntity.status(HttpStatus.OK).body(v);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@RequestBody Voto voto, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(voto);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}