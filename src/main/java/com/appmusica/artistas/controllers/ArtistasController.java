package com.appmusica.artistas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appmusica.artistas.models.Artista;
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
	

	@DeleteMapping(value = "/delete/{idArtista}/{idCancion}")
	public ResponseEntity<String> deleteCancion(@PathVariable(name = "idArtista") Long idAritsta,@PathVariable(name = "idCancion") Long idCancion){
		
		if(cancionServices.getCancion(idCancion)==null) {
			 return ResponseEntity.ok("La canción no existe");
		}
		
		if(artistasServices.EliminarCancion(idAritsta, idCancion)) {
			 return ResponseEntity.ok("Se eliminó la canción correctamente");
		}
		
		 return ResponseEntity.ok("No se pudo eliminar la canción");
	}
	

	@PutMapping(value = "/update/{idArtista}")
	public ResponseEntity<?> updateCancion(@PathVariable(name = "idArtista") Long idAritsta,@RequestBody Cancion cancion){
		
		Cancion cancionActualizada = artistasServices.editarCancion(idAritsta, cancion);
		
		if (cancionActualizada == null) {
			return ResponseEntity.ok("No se encontró la canción");
		} else {
			return ResponseEntity.ok(cancionActualizada);
		}
		
	}
	
	

	@PostMapping(value = "/save/{idArtista}")
	public ResponseEntity<String> publicarCancion(@RequestBody Cancion cancion,@PathVariable(name = "idArtista")Long id){
		
		if(artistasServices.publicarCancion(cancion,id)) {
			return ResponseEntity.ok("Se ha publicado la canción correctamente");
			
			
		}
		
		 return ResponseEntity.ok("No pudo publicar la canción");
	}
	
	
	@GetMapping(value = "/search/{idCancion}")
	public ResponseEntity<?> buscarCancion(@PathVariable(name = "idCancion") Long idCancion){
		
		if(cancionServices.getCancion(idCancion)==null) {
			return new ResponseEntity<String>("No se encontró la cancion",HttpStatus.OK);
		}
		
		else {
			return ResponseEntity.ok(cancionServices.getCancion(idCancion));
		}
		
	}
		 
	

	@GetMapping(value = "/artistas")
	public ResponseEntity<List<Artista>> listarArtistas(){
		
		List<Artista> canciones= artistasServices.getArtistas();
		
		return ResponseEntity.ok(canciones);
		
	}
	
	@Autowired
	private ArtistasServices artistasServices;
	
	@Autowired 
	private CancionServices cancionServices;
	
}