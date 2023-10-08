package com.appmusica.artistas.services.implementations;
import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.appmusica.artistas.models.Artista;
import com.appmusica.artistas.models.Cancion;
import com.appmusica.artistas.repostories.ArtistaRepository;
import com.appmusica.artistas.repostories.CancionRepository;
import com.appmusica.artistas.services.ArtistasServices;

/**
 * 
 *@Author Mateo Rodriguez
 *
 *
 *
 */
@Service
@Primary
public class ArtistasServicesImpl implements ArtistasServices {

	

	@Override
	public Boolean publicarCancion(Cancion cancion) {
		cancion.setEstreno(new Timestamp(System.currentTimeMillis()));;
		
		Cancion cancionGuardada= cancionRepository.save(cancion);
		
		return cancionRepository.existsById(cancionGuardada.getId());
	}

	@Override
	public Boolean EliminarCancion(Long idAritsta, Long idCancion) {
		
		Artista artista = artistaRepository.findById(idAritsta).orElse(null);
		
		Optional<Cancion> cancionDelet=artista.getCanciones()
				.stream()
				.filter(c -> c.getId().equals(idCancion))
				.findFirst();
		
		cancionDelet.ifPresent(cancionRepository::delete);
		
		return !cancionRepository.existsById(idCancion);
	}

	@Override
	public Cancion editarCancion(Long idAritsta,Cancion cancion) {
		
		Optional<Cancion> cancionUpdate= artistaRepository
				.findById(idAritsta)
				.orElse(null)
				.getCanciones()
				.stream()
				.filter(c -> c.getId().equals(cancion.getId()))
				.findFirst();
		
		if(cancionUpdate.isPresent()) {
			return cancionRepository.save(cancion);
		}
		
		return null;
	}

	
	
	@Autowired
	private CancionRepository cancionRepository;
	
	@Autowired
	private ArtistaRepository artistaRepository;


}
