package com.example.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Ingrediente;

@Repository
public interface IIngredeineteRepo extends JpaRepository<Ingrediente, Integer> {
	
	
  
   @Query(value = "SELECT sum(calorias) FROM public.ingrediente where _id_menu=?1 GROUP BY _id_menu", nativeQuery=true)
   Integer sumaIngrediente(Integer id);
   
   @Query(value = "SELECT count(a) FROM Ingrediente a WHERE a.Id = ?1")
   BigInteger validarExistenciaPorId(Integer id);
	
	

}
