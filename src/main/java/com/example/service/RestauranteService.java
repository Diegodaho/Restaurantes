package com.example.service;


import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.entity.Restaurante;
import com.example.exeption.ArgumentRequiredException;
import com.example.exeption.BusinessLogicException;
import com.example.exeption.ModelNotFoundException;
import com.example.repository.IRestauranteRepo;
import com.example.serviceIimpl.IRestauranteService;

@Service
public class RestauranteService implements IRestauranteService {
	
	@Autowired
	private IRestauranteRepo repo;

	@Override
	public List<Restaurante> listarFacade() {
		
       List <Restaurante> lista = repo.findAll();
		
	   if(lista==null) {
		   
		   new ModelNotFoundException("No hay elementos de la lista");
		   
	   }
	   
	   
	   for (Restaurante rest : lista) {
			rest.setMenu(null);
		}
		
		return lista;
		
		
	}

	@Override
	public Restaurante listarPooIdFacede(Integer id) {
		Restaurante rest = repo.findById(id).orElseThrow(() 
				-> new ModelNotFoundException("Restaurante no encontrado"));
		
		if(rest.getMenu()!=null) {
			
			rest.setMenu(null);
		}
		
	   
		
		 
			
			return rest;
	}

	@Override
	public void gusardarFacade(Restaurante clase) {
		
		List<Restaurante> rest = repo.findAll();
		
		
		for(Restaurante re: rest ) {
			
			if(clase.getNombreComercial().equals(re.getNombreComercial())) {
				
				
				throw new BusinessLogicException("Ya existe un restaurante con ese nombre" );
			}
			
		}
		
		
		
		
	
		repo.save(clase);
		
		

		
	}

	@Override
	public void editarFacade(Restaurante clase) {
		
		if(clase.getId() == null)
			throw new ArgumentRequiredException("Id Restaurante es requerido");
		
		Restaurante rest = repo.findById(clase.getId()).orElseThrow(() 
				-> new ModelNotFoundException("Id Restaurante no fue encontrado"));	
		
		if(clase.getHora_apertura().before(rest.getHora_cierre()) || clase.getHora_cierre().after(rest.getHora_apertura()) ) {
			
			rest.setRazonSocial(clase.getRazonSocial());
			rest.setNombreComercial(clase.getNombreComercial());
			rest.setTipoRestaurante(clase.getTipoRestaurante());
			rest.setUbicacion(clase.getUbicacion());
			rest.setHora_apertura(clase.getHora_apertura());
			rest.setHora_cierre(clase.getHora_cierre());
			
			
					
			repo.save(rest);
			
		}else{
			
			
			new BusinessLogicException(" La fecha de Apertura tiene que ser menor a la fecha Cierre" );
			
			
		}
		
		if(clase.getHora_apertura().before(clase.getHora_cierre())) {
			
			rest.setRazonSocial(clase.getRazonSocial());
			rest.setNombreComercial(clase.getNombreComercial());
			rest.setTipoRestaurante(clase.getTipoRestaurante());
			rest.setUbicacion(clase.getUbicacion());
			rest.setHora_apertura(clase.getHora_apertura());
			rest.setHora_cierre(clase.getHora_cierre());
			
			
					
			repo.save(rest);
			
			
			
		}else {
			
			new BusinessLogicException(" La fecha de Apertura tiene que ser menor a la fecha Cierre" );
			
		}
		
	
		
		
				
		
	}

	@Override
	public void eliminarFacade(Integer id) {
		
		Restaurante rest = repo.findById(id).orElseThrow(() 
				-> new ModelNotFoundException("Restaurante no encontrado"));
		
		if(rest.getMenu() != null && rest.getMenu().size() > 0) {
			throw new BusinessLogicException("El restaurante Tiene Menus (Porfavor eliminar los menus) " );
		}else {
			repo.deleteById(id);
			
			
		}
		
		

		
	}

	@Override
	public BigInteger traer(Integer tan) {
		BigInteger fan= repo.validarExistenciaPorId(tan);
		if(fan.intValue()==0) {
			throw new ModelNotFoundException("Autor no encontrado");
		}
		
		return fan;
			
		
	}

	

}
