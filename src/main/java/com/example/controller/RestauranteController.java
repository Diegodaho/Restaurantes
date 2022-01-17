package com.example.controller;



import java.math.BigInteger;
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
import com.example.entity.Restaurante;
import com.example.serviceIimpl.IRestauranteService;



@RestController
@RequestMapping("/restaurantess")
public class RestauranteController {
	
	@Autowired
	private IRestauranteService service;
	
	@PostMapping("/guardarFacade")
	public ResponseEntity<Object> guardarFacade(@Valid @RequestBody Restaurante obj) {
		service.gusardarFacade(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public  ResponseEntity<List<Restaurante>> listarTodo() {		
		List<Restaurante> listar = service.listarFacade();
		return new ResponseEntity<List<Restaurante>>(listar, HttpStatus.OK);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Object> editar(@Valid @RequestBody Restaurante obj) {
		service.editarFacade(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Restaurante> listarPorId(@PathVariable int id)  {
		Restaurante rest = service.listarPooIdFacede(id);
			return new ResponseEntity<Restaurante>(rest, HttpStatus.OK);					
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Restaurante> eliminar(@PathVariable int id)  {
			service.eliminarFacade(id);
			return new ResponseEntity<Restaurante>(HttpStatus.NO_CONTENT);					
	}
	@GetMapping("/listar66/{id}")
	public ResponseEntity<BigInteger> listarPofeo(@PathVariable Integer id)  {
		BigInteger rest = service.traer(id);
			return new ResponseEntity<BigInteger>(rest, HttpStatus.OK);					
	}
	
	
		

}
