package com.appmusica.artistas.services;

import java.util.List;

import com.appmusica.artistas.models.Cancion;

public interface CancionServices {

	/**
	 * 
	 * @param idArtista
	 * @return
	 */
	List<Cancion> getCancionesByArtista(Long idArtista);
	
	/**
	 * 
	 * @return
	 */
	List<Cancion> getCanciones();
	
	/**
	 * 
	 * @param idCancion
	 * @return
	 */
	Cancion getCancion (Long idCancion);
	
}
