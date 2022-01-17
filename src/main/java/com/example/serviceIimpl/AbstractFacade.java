package com.example.serviceIimpl;

import java.util.List;



public abstract interface AbstractFacade <T, V>{
	
	public List<T> listarFacade();
	public  T listarPooIdFacede(V id);
	public void gusardarFacade(T clase);
	public void editarFacade(T clase);
	public void eliminarFacade(V id);

}
