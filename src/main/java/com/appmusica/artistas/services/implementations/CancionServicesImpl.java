package com.appmusica.artistas.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.appmusica.artistas.models.Artista;
import com.appmusica.artistas.models.Cancion;
import com.appmusica.artistas.repostories.ArtistaRepository;
import com.appmusica.artistas.repostories.CancionRepository;
import com.appmusica.artistas.services.CancionServices;

@Service
@Primary
public class CancionServicesImpl implements CancionServices{


	@Override
	public List<Cancion> getCancionesByArtista(Long idArtista) {

		Artista artista=artistaRepository
				.findById(idArtista)
				.orElse(null);		
		
		return artista.getCanciones();
	}

	@Override
	public List<Cancion> getCanciones() {
		
		return cancionRepository.findAll();
	}

	@Override
	public Cancion getCancion(Long idCancion) {
		return cancionRepository.findById(idCancion)
				.orElseThrow(() -> new RuntimeException("cancion not found"));
	}

	
	@Autowired
	private CancionRepository cancionRepository;
	
	@Autowired
	private ArtistaRepository artistaRepository;
}
