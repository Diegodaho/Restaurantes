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

import com.example.entity.Menu;
import com.example.entity.Restaurante;
import com.example.serviceIimpl.IMenuServices;
import com.example.view.MenuResNombreView;
import com.example.view.MenuRestView;


@RestController
@RequestMapping("/menus")
public class MenuController {
	
	@Autowired
	private IMenuServices service;
	
	
	@PostMapping("/guardarFacade")
	public ResponseEntity<Object> guardarFacade(@Valid @RequestBody Menu obj) {
		service.gusardarFacade(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public  ResponseEntity<List<Menu>> listarTodo() {		
		List<Menu> listar = service.listarFacade();
		return new ResponseEntity<List<Menu>>(listar, HttpStatus.OK);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Object> editar(@Valid @RequestBody Menu obj) {
		service.editarFacade(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Menu> listarPorId(@PathVariable int id)  {
		Menu rest = service.listarPooIdFacede(id);
			return new ResponseEntity<Menu>(rest, HttpStatus.OK);					
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Restaurante> eliminar(@PathVariable int id)  {
			service.eliminarFacade(id);
			return new ResponseEntity<Restaurante>(HttpStatus.NO_CONTENT);					
	}
	
	@GetMapping("/listarview/{id}")
	public  ResponseEntity<List<MenuRestView>> listarTodo(@PathVariable int id) {		
		List<MenuRestView> listar = service.listarMenuRest(id);
		return new ResponseEntity<List<MenuRestView>>(listar, HttpStatus.OK);
	}
	
	@GetMapping("/listarview")
	public  ResponseEntity<List<MenuRestView>> listarTodo1() {		
		List<MenuRestView> listar =  service.listarMenuRestva();
		return new ResponseEntity<List<MenuRestView>>(listar, HttpStatus.OK);
	}
	
	@GetMapping("/listarviewNom")
	public  ResponseEntity<List<MenuResNombreView>> listarTodoNom() {		
		List<MenuResNombreView> listar =  service.listarMenuRestvaNombre();
		return new ResponseEntity<List<MenuResNombreView>>(listar, HttpStatus.OK);
	}
	

}
