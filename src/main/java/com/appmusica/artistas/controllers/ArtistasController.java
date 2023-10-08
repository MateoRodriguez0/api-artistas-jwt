package com.appmusica.artistas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appmusica.artistas.models.Cancion;
import com.appmusica.artistas.services.ArtistasServices;
import com.appmusica.artistas.services.CancionServices;

@RestController
@RequestMapping(value = "/canciones")
public class ArtistasController {
	
	@GetMapping(value = "/explorar")
	public ResponseEntity<List<Cancion>> explorarCanciones(){
		
		List<Cancion> canciones= cancionServices.getCanciones();
		
		return ResponseEntity.ok(canciones);
		
	}
	
	@GetMapping(value = "/artista/{idArtista}")
	public ResponseEntity<List<Cancion>> cancionesPorArtista(@PathVariable(name = "idArtista")Long idArtista){
		
		return ResponseEntity
				.ok(cancionServices
						.getCancionesByArtista(idArtista));
	}
	

	public ResponseEntity<String> deleteCancion(Long idAritsta, Long idCancion){
		
		if(artistasServices.EliminarCancion(idAritsta, idCancion)) {
			 return ResponseEntity.ok("Se eliminó la canción correctamente");
		}
		
		 return ResponseEntity.unprocessableEntity().body("No pudo eliminar la canción");
	}
	

	@PostMapping(value = "/update/{idArtista}")
	public ResponseEntity<Object> updateCancion(@PathVariable(name = "idArtista") Long idAritsta,@RequestBody Cancion cancion){
		
		if(artistasServices.editarCancion(idAritsta, cancion)==null) {
			ResponseEntity.unprocessableEntity().body("No pudo eliminar la canción");
			
		}
		
		 return ResponseEntity.ok(artistasServices.editarCancion(idAritsta, cancion));
	}
	
	
	
	@PostMapping(value = "/update")
	public ResponseEntity<Object> publicarCancion(@RequestBody Cancion cancion){
		
		if(artistasServices.publicarCancion(cancion)) {
			return ResponseEntity.ok("Se ha publicado la canción correctamente");
			
			
		}
		
		 return ResponseEntity.unprocessableEntity().body("No pudo publicar la canción");
	}
	
	
	
	
	@Autowired
	private ArtistasServices artistasServices;
	
	@Autowired
	private CancionServices cancionServices;
	
}
