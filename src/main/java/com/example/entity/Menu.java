package com.example.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;




@Entity
@Table(name = "menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer Id;
	
	@NotNull(message="Porfavor Ingresar El tipo de MENU (4 Tipos: Entrada, Plato Fuerte, Postres, Bebidas)")
	@Column(name = "tip_menu", nullable = false, length = 20)
	private String tipoMenu;
	
	@NotNull(message="Porfavor Ingresar nombre de Menu")
	@Column(name = "nom_menu", nullable = false, length = 20)
	private String nombreMenu;
	
	@NotNull(message="Porfavor Ingresar el precio")
	@Column(name = "precio", nullable = false)
	private Double preio;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "_id_rest", nullable = false, foreignKey = @ForeignKey(name = "FK_Restaurante_Menu"))	
	private Restaurante restaurant;
	
	@OneToMany(mappedBy = "menus", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Ingrediente> ingredi;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getTipoMenu() {
		return tipoMenu;
	}

	public void setTipoMenu(String tipoMenu) {
		this.tipoMenu = tipoMenu;
	}

	public String getNombreMenu() {
		return nombreMenu;
	}

	public void setNombreMenu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}

	public Double getPreio() {
		return preio;
	}

	public void setPreio(Double preio) {
		this.preio = preio;
	}

	@JsonIgnore
	public Restaurante getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurante restaurant) {
		this.restaurant = restaurant;
	}
	
	
	public List<Ingrediente> getIngredi() {
		return ingredi;
	}

	public void setIngredi(List<Ingrediente> ingredi) {
		this.ingredi = ingredi;
	}
	
	


	

	
	
	
	
	
	
	
	
	

}
