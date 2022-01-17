package com.example.serviceIimpl;


import java.util.List;

import com.example.entity.Menu;
import com.example.view.MenuResNombreView;
import com.example.view.MenuRestView;


public interface IMenuServices extends AbstractFacade<Menu, Integer>{
	
	public List<MenuRestView> listarMenuRest(Integer id);
	
	public  List<MenuRestView> listarMenuRestva();
	
	public  List<MenuResNombreView> listarMenuRestvaNombre();

}
