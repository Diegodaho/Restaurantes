package com.example.controller;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Ingrediente;

import com.example.serviceIimpl.IIngredienteService;


@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {
	
	@Autowired
	private IIngredienteService service;
	
	@PostMapping("/guardarFacade")
	public ResponseEntity<Object> guardarFacade(@Valid @RequestBody Ingrediente obj) {
		service.gusardarFacade(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Ingrediente> listarPorId(@PathVariable int id)  {
		Ingrediente rest = service.listarPooIdFacede(id);
			return new ResponseEntity<Ingrediente>(rest, HttpStatus.OK);					
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Object> editar(@Valid @RequestBody Ingrediente obj) {
		service.editarFacade(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	@GetMapping("/listar")
	public  ResponseEntity<List<Ingrediente>> listarTodo() {		
		List<Ingrediente> listar = service.listarFacade();
		return new ResponseEntity<List<Ingrediente>>(listar, HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Ingrediente> eliminar(@PathVariable int id)  {
			service.eliminarFacade(id);
			return new ResponseEntity<Ingrediente>(HttpStatus.NO_CONTENT);					
	}

}
