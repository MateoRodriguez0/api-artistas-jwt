package com.appmusica.artistas.services.implementations;
import java.sql.Timestamp;
import java.util.List;
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
	public Boolean publicarCancion(Cancion cancion,Long id) {
		
	    Optional<Artista> artistaOptional = artistaRepository.findById(id);
	    
	    if (artistaOptional.isPresent()) {
	    	
	        Artista artista = artistaOptional.get();
	      
	        artista.getCanciones().add(cancion);
	        cancion.addartist(artista);
	        cancion.setEstreno(new Timestamp(System.currentTimeMillis()));
	        cancionRepository.save(cancion);
	        
	        return true;
	    }
	    
	    return false;
	}

	@Override
	public Boolean EliminarCancion(Long idArtista, Long idCancion) {
		
		Artista artista = artistaRepository.findById(idArtista).orElse(null);
		
		if(artista!=null && cancionRepository.existsById(idCancion) ) {
			
			Optional<Cancion> cancionDelet=artista.getCanciones()
					.stream()
					.filter(c -> c.getId().equals(idCancion))
					.findFirst();
		
			if(cancionDelet.isPresent()) {
			
				 for (Artista art : cancionDelet.get().getArtistas()) {
					 
					 art.getCanciones().remove(cancionDelet.get());
		            }
				
				artistaRepository.saveAll(cancionDelet.get().getArtistas());
				cancionRepository.deleteById(idCancion);
			}
		
			
		
		}
		return !cancionRepository.existsById(idCancion);
		
	}

	@Override
	public Cancion editarCancion(Long idAritsta,Cancion cancion) {
		
		Optional<Artista> artistaUpdate= artistaRepository
				.findById(idAritsta);
		
		Optional<Cancion> cancionUpdate=Optional.empty();
		
		if(artistaUpdate.isPresent()) {
			
			cancionUpdate=artistaUpdate.get().getCanciones()
					.stream()
					.filter(c -> c.getId().equals(cancion.getId()))
					.findFirst();
		}
				
		
		if(cancionUpdate.isPresent()) {
			return cancionRepository.save(cancion);
		}
		else {
			return null;
		}
		
	}
	
	@Override
	public List<Artista> getArtistas() {
		return artistaRepository.findAll();
	}
	
	
	@Autowired
	private CancionRepository cancionRepository;
	
	@Autowired
	private ArtistaRepository artistaRepository;

	


}
