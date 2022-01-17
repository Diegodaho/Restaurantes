package com.example.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "menu_res_nombre")
@Immutable
public class MenuResNombreView {
	
	@Id
	@Column(name = "id")
	private Integer Id;
	
	@Column(name = "tip_menu")
	private String tipMenu;
	
	@Column(name = "nom_menu")
	private String nomMenu;
	
	
	@Column(name = "precio")
	private Double precio;
	
	
	@Column(name = "nom_comercial")
	private String nomRes;


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


	public String getNomRes() {
		return nomRes;
	}


	public void setNomRes(String nomRes) {
		this.nomRes = nomRes;
	}
	
	


	
	



}
