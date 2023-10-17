package com.appmusica.artistas.repostories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appmusica.artistas.models.Cancion;
import com.appmusica.artistas.models.Artista;
import java.util.List;
import java.util.Optional;




public interface CancionRepository extends JpaRepository<Cancion, Long> {

	
	Optional<List<Cancion>> findByArtistas(Artista artistas);
}
