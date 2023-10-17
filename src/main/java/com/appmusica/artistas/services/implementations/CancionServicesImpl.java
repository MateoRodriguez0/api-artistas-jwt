package com.appmusica.artistas.services.implementations;

import java.util.List;
import java.util.Optional;

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

		Optional<Artista> artista=artistaRepository
				.findById(idArtista);		
		
		if(artista.isPresent()) {
			return cancionRepository.findByArtistas(artista.get()).get();
		}
		 
		return null;
	}

	@Override
	public List<Cancion> getCanciones() {
		
		return cancionRepository.findAll();
	}

	@Override
	public Cancion getCancion(Long idCancion) {
		return cancionRepository.findById(idCancion)
				.orElse(null);
	}

	
	@Autowired
	private CancionRepository cancionRepository;
	
	@Autowired
	private ArtistaRepository artistaRepository;
}
