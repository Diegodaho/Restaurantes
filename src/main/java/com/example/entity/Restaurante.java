package com.example.entity;




import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "restaurante")
public class Restaurante {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer Id;
	
	@NotNull(message="Porfavor Ingresar Razon Socual")
	@Column(name = "razon_social", nullable = false, length = 50)
	private String razonSocial;
	
	@NotNull(message="Porfavor Nombre del comercial")
	@Column(name = "nom_comercial", nullable = false, length = 50)
	private String nombreComercial;
	
	@NotNull(message="Porfavor Ingresar Tipo de restaurante:  4 tipos(Vegano,Vegetariano,Carnes Rojas y Aves,)")
	@Column(name = "tip_rest", nullable = false, length = 20)
	private String tipoRestaurante;
	
	@NotNull(message="Porfavor Ingrear la ubicacion del lugar(Ciuddad)")
	@Column(name = "ciudadUbi", nullable = false, length = 20)
	private String ubicacion;
	
	@NotNull(message="Profavor ingresar hora de apertura")
	@Column(name = "hora_apert", nullable = false)
    //@Temporal(TemporalType.TIME)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="HH:mm:ss")
	private Time hora_apertura;
	

	@NotNull(message="Profavor ingresar hora de cierre")
	@Column(name = "hora_cierre", nullable = false)
	//@Temporal(TemporalType.TIME)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="HH:mm:ss")
	private Time hora_cierre;
	
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Menu> menu;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getTipoRestaurante() {
		return tipoRestaurante;
	}

	public void setTipoRestaurante(String tipoRestaurante) {
		this.tipoRestaurante = tipoRestaurante;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Time getHora_apertura() {
		return hora_apertura;
	}

	public void setHora_apertura(Time hora_apertura) {
		this.hora_apertura = hora_apertura;
	}

	public Time getHora_cierre() {
		return hora_cierre;
	}

	public void setHora_cierre(Time hora_cierre) {
		this.hora_cierre = hora_cierre;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	
	


	
	




	
	


	
	
	
	
	

}
