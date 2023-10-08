package com.appmusica.artistas.repostories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appmusica.artistas.models.Cancion;



public interface CancionRepository extends JpaRepository<Cancion, Long> {

}
