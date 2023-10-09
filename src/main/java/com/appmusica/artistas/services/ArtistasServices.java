package com.appmusica.artistas.services;

import java.util.List;

import com.appmusica.artistas.models.Artista;
import com.appmusica.artistas.models.Cancion;

/**
 * 
 *@Author Mateo Rodriguez
 *
 */
public interface ArtistasServices {



	/**
	 * 
	 * @param cancion es la cancion que sera guardada en la base de datos
	 * @return true si la cancion se guardo correctamente
	 */
	Boolean publicarCancion(Cancion cancion,Long id);
	
	/**
	 * elimina una cancion de la base de tatos siempre verificando que el artista con idArtista 
	 * este relacionado con la cancion  a traves de idCancion
	 * 
	 * @param idAritsta id del artista a sociado a la cancion
	 * @param idCancion es el id de la cancion que sera eliminada
	 * @return true si la cancion se elimina correctamente
	 */
	Boolean EliminarCancion(Long idAritsta, Long idCancion);
	

	/**
	 * 
	 * @param cancion cancion con los campos que seran editados
	 * @return la cancion luego de ser editada
	 */
	Cancion editarCancion(Long idAritsta,Cancion cancion);
	
	
	/**
	 * 
	 * @return
	 */
	List<Artista> getArtistas();
	
	
	
}
