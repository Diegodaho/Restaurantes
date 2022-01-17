package com.example.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.view.MenuRestView;


@Repository
public interface MenuRestViewRepo extends JpaRepository<MenuRestView, Integer> {
	
	@Query(value = "Select * from view_Menu_res where _id_rest=?1", nativeQuery=true)
	List<MenuRestView> vistaMenuRest(Integer id);
	
	


}
