package com.example.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Menu;
import com.example.entity.Restaurante;
import com.example.exeption.ArgumentRequiredException;
import com.example.exeption.BusinessLogicException;
import com.example.exeption.ModelNotFoundException;
import com.example.repository.IMenuRepo;
import com.example.repository.IRestauranteRepo;
import com.example.repository.MenuResNombreRepo;
import com.example.repository.MenuRestViewRepo;
import com.example.serviceIimpl.IMenuServices;
import com.example.view.MenuResNombreView;
import com.example.view.MenuRestView;

@Service
public class MenuService implements IMenuServices {
	
	
	@Autowired
	private IMenuRepo repo;
	
	@Autowired
	private MenuRestViewRepo repoview;
	
	@Autowired
	private MenuResNombreRepo repviewNom;
	
	@Autowired
	private IRestauranteRepo repoRes;

	@Override
	public List<Menu> listarFacade() {
		  List <Menu> lista = repo.findAll();
			
		   if(lista==null) {
			   
			   new ModelNotFoundException("No hay elementos de la lista");
			   
		   }
		return lista;
	}

	@Override
	public Menu listarPooIdFacede(Integer id) {
		Menu menu = repo.findById(id).orElseThrow(() 
				-> new ModelNotFoundException("Menu no encontrado"));	

		
		return menu;
	}

	@Override
	public void gusardarFacade(Menu clase) {
		
		
		
		if(clase.getRestaurant() != null && clase.getRestaurant().getId() != null) {
			BigInteger contador = repoRes.validarExistenciaPorId(clase.getRestaurant().getId());
			System.out.println(contador);
			if(contador.intValue() > 0) {
				
				Menu menu = new Menu();
				menu.setTipoMenu(clase.getTipoMenu());
				menu.setNombreMenu(clase.getNombreMenu());
				menu.setPreio(clase.getPreio());
				
				
				Restaurante resta = new Restaurante();
				resta.setId(clase.getRestaurant().getId());
				
				
				menu.setRestaurant(resta);
				repo.save(clase);
			}else {
				throw new ModelNotFoundException("Autor no encontrado");
			}
		} else {
			throw new ArgumentRequiredException("Id Autor es requerido");
		}
	
	}

	@Override
	public void editarFacade(Menu clase) {
		
		if(clase.getId() == null)
			throw new ArgumentRequiredException("Id Menu es requerido");
		
		Menu menu = repo.findById(clase.getId()).orElseThrow(() 
				-> new ModelNotFoundException("Menu no encontrado"));	
		
		menu.setTipoMenu(clase.getTipoMenu());
		menu.setNombreMenu(clase.getNombreMenu());
		menu.setPreio(clase.getPreio());
		
		
		
				
		repo.save(menu);
		
	}

	@Override
	public void eliminarFacade(Integer id) {
		
		Menu men = this.listarPooIdFacede(id);
		
		if(men.getIngredi() != null && men.getIngredi().size() > 0) {
			throw new BusinessLogicException("El menu tiene ingredientes (Porfavor elimina los ingredientes) " );
		}else {
			repo.deleteById(id);
			
			
		}
		
	}

	@Override
	public List<MenuRestView> listarMenuRest(Integer id) {
		
		List<MenuRestView> listar = repoview.vistaMenuRest(id);
		
		return listar;
	}

	
	@Override
	public List<MenuRestView> listarMenuRestva() {
		
		List<MenuRestView> fan = repoview.findAll();
		
		if(fan==null) {
			  new ModelNotFoundException("No hay elementos de la lista");
		}
		
		return fan ;
		
		
	}

	@Override
	public List<MenuResNombreView> listarMenuRestvaNombre() {
		
		List<MenuResNombreView> tan = repviewNom.findAll();
		
		return tan;
	}

}
