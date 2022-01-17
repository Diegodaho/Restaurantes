package com.example.view;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "view_Menu_res")
@Immutable
public class MenuRestView {
	
	@Id
	@Column(name = "id")
	private Integer Id;
	
	@Column(name = "tip_menu")
	private String tipMenu;
	
	@Column(name = "nom_menu")
	private String nomMenu;
	
	
	@Column(name = "precio")
	private Double precio;
	
	
	@Column(name = "_id_rest")
	private Integer idRest;


	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public String getTipMenu() {
		return tipMenu;
	}


	public void setTipMenu(String tipMenu) {
		this.tipMenu = tipMenu;
	}


	public String getNomMenu() {
		return nomMenu;
	}


	public void setNomMenu(String nomMenu) {
		this.nomMenu = nomMenu;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public Integer getIdRest() {
		return idRest;
	}


	public void setIdRest(Integer idRest) {
		this.idRest = idRest;
	}


	
	
	

}
