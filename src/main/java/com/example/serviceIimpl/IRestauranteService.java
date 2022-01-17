package com.example.serviceIimpl;


import java.math.BigInteger;
import java.util.List;

import com.example.entity.Restaurante;


public interface IRestauranteService extends AbstractFacade<Restaurante, Integer> {
	
	public BigInteger traer(Integer tan);
}
