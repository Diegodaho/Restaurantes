package com.example.repository;


import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;


import com.example.entity.Restaurante;

@Repository
public interface IRestauranteRepo extends JpaRepository<Restaurante, Integer> {
	
	
	
	@Query("SELECT a from Restaurante a")
	public Restaurante encontrarrNombre(Sort sort);
	
	@Query(value = "SELECT count(a) FROM Restaurante a WHERE a.Id = ?1")
    BigInteger validarExistenciaPorId(Integer id);
	
	
	
	
	

}
