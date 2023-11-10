package ar.edu.ubp.das.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.ubp.das.rest.beans.PersonaBean;
import ar.edu.ubp.das.rest.beans.PersonaDataBean;
import ar.edu.ubp.das.rest.repository.PersonaRepository;

@RestController
@RequestMapping(
  path="/api/personas",
  produces={MediaType.APPLICATION_JSON_VALUE}
)

public class PersonaController {
	
    @Autowired
    PersonaRepository repository;
	
    @GetMapping(path="/datos/{id}")
    public ResponseEntity<List<PersonaDataBean>> getPersona( @PathVariable("id") String id ) {
      return new ResponseEntity<>(repository.getPersona(id), HttpStatus.OK);
    }
    
    @GetMapping(path="/listado")
    public ResponseEntity<List<PersonaBean>> getPersonas() {
      return new ResponseEntity<>(repository.getPersonas(), HttpStatus.OK);
    }
    
    @PostMapping(
        	path="/add",
        	consumes={MediaType.APPLICATION_JSON_VALUE}
        )
    	public ResponseEntity<PersonaDataBean> insPersona(@RequestBody PersonaDataBean persona) {
        	return new ResponseEntity<>(repository.insPersona(persona), HttpStatus.CREATED);
    	}
    

}
