package com.appmusica.artistas.models;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.appmusica.artistas.models.Cancion;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * entidad que mapea a una tabla llamada canciones en la base de datos.
 * 
 * @Author Mateo Rodriguez
 *
 */
@Entity
@Table(name = "canciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cancion {

	public Cancion(String titulo,String genero, Time duracion, List<Artista> artistas) {
		
		this.titulo=titulo;
		this.genero=genero;
		this.duracion=duracion;
		this.artistas=artistas;

		
	}

	public Cancion(String titulo,String genero, Time duracion) {
		
		this.titulo=titulo;
		this.genero=genero;
		this.duracion=duracion;
	
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "genero")
	private String genero;
	
	// Campo para la hora
    @Temporal(TemporalType.TIME)
    @Column(name="duracion")
    private Time duracion;

	@Column(name = "fechaPublicacion")
	private Timestamp estreno;

	@ManyToMany(mappedBy = "canciones",cascade = CascadeType.PERSIST)
	private List<Artista> artistas;
	
	

	public void addartist(Artista artista) {
		if(artistas==null) {
			artistas= new ArrayList<>();
		}
		
		artistas.add(artista);
	}
	
}

