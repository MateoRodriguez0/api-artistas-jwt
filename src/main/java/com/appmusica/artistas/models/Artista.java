package com.appmusica.artistas.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "artistas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artista {

	public Artista(Long id) {
		this.id=id;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombreArtistico")
	private String nombre;
	
	
	@JsonIgnore
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinTable(name = "canciones_artistas",
		joinColumns = @JoinColumn(name="idArtista"),
		inverseJoinColumns = {@JoinColumn(name="idCancion")})
	private List<Cancion> canciones;
}
