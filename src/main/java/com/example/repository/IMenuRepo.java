package com.example.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Menu;
import com.example.view.MenuRestView;

@Repository
public interface IMenuRepo extends JpaRepository<Menu, Integer>{
	
	@Query(value = "SELECT count(a) FROM Menu a WHERE a.Id = ?1")
    BigInteger validarExistenciaPorId(Integer id);
	
	
	
	

}
