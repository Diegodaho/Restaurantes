package com.example.service;

import java.math.BigInteger;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Ingrediente;
import com.example.entity.Menu;
import com.example.exeption.ArgumentRequiredException;
import com.example.exeption.BusinessLogicException;
import com.example.exeption.ModelNotFoundException;
import com.example.repository.IIngredeineteRepo;
import com.example.repository.IMenuRepo;
import com.example.serviceIimpl.IIngredienteService;

@Service
public class IngredienteService implements IIngredienteService {
	
	
	@Autowired
	private IMenuRepo repoMen;
	
	@Autowired
	private IIngredeineteRepo repo;

	@Override
	public List<Ingrediente> listarFacade() {
		 List <Ingrediente> lista = repo.findAll();
			
		   if(lista==null) {
			   
			   new ModelNotFoundException("No hay elementos de la lista");
			   
		   }
		return lista;
	}

	@Override
	public Ingrediente listarPooIdFacede(Integer id) {
		Ingrediente ingre = repo.findById(id).orElseThrow(() 
				-> new ModelNotFoundException("Ingrediente no encontrado"));	

		
		return ingre;
	}

	@Override
	public void gusardarFacade(Ingrediente clase) {
		
		if(clase.getMenus()!= null && clase.getMenus().getId() != null) {
			
			BigInteger contador = repoMen.validarExistenciaPorId(clase.getMenus().getId());
			System.out.println(contador);
			if(contador.intValue() > 0) {
				
				if(clase.getCalorias()<2000) {
					
					Integer suma = repo.sumaIngrediente(clase.getCalorias());

					if(suma != null) {
						
					Integer total= suma +clase.getCalorias();
						
						
						 if(total <2000) {
								
								Ingrediente ingre = new Ingrediente();
								ingre.setNombre(clase.getNombre());
								ingre.setCalorias(clase.getCalorias());
								
								Menu menu = new Menu();
								menu.setId(clase.getMenus().getId());
					
								clase.setMenus(menu);
								repo.save(clase);	
		
							    }
		                        else {
		    						
		                        	throw new BusinessLogicException("Porfavor agregar menos calorias");
		    					}
						 
					}else {
						
						Ingrediente ingre = new Ingrediente();
						ingre.setNombre(clase.getNombre());
						ingre.setCalorias(clase.getCalorias());
						
						Menu menu = new Menu();
						menu.setId(clase.getMenus().getId());
			
						clase.setMenus(menu);
						repo.save(clase);

					}
				
				}else {
					
					 throw new BusinessLogicException("La caloria deben ser menor a 2000");
					}
				
			}else {
				throw new ModelNotFoundException("Menu no encontrado");
				}
			
			
		} else {
			throw new ArgumentRequiredException("Id Menu es requerido");
		}
		
	}

	@Override
	public void editarFacade(Ingrediente clase) {
		if(clase.getId() == null)
			throw new ArgumentRequiredException("Id Ingrediente  es requerido");
		
			
		
		Ingrediente ingrede = repo.findById(clase.getId()).orElseThrow(() 
				-> new ModelNotFoundException("Id Ingrediente no encontrada"));
		
		
		if(clase.getCalorias() <2000) {
			
			
			Integer suma = repo.sumaIngrediente(ingrede.getMenus().getId());
			 
			Integer result = suma - ingrede.getCalorias();
			
			Integer total= result +clase.getCalorias();
			
		
			
			
			 if(total <2000) {
					
				
				
				ingrede.setNombre(clase.getNombre());
		        ingrede.setCalorias(clase.getCalorias());
				
		        repo.save(ingrede);
				
				
			 }
			 
			 else {
				 
				 throw new BusinessLogicException("La caloria deben ser menor a 2000");
				 
			 }
		
			
		}else {
			
			throw new BusinessLogicException("La caloria deben ser menor a 2000 " );
			
		}
        
		
	}

	@Override
	public void eliminarFacade(Integer id) {
		boolean exis= repo.existsById(id);
		
		if(exis==false) {
			new ModelNotFoundException("Ingrediente no encontrado");
		}
	     repo.deleteById(id);
	}

	@Override
	public Integer toralC(Integer sum) {
		// TODO Auto-generated method stub
		Integer suma = repo.sumaIngrediente(sum);
		
		return suma;
	}

}
