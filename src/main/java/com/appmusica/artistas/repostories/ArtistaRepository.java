package com.appmusica.artistas.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appmusica.artistas.models.Artista;

public interface ArtistaRepository  extends JpaRepository<Artista, Long>{

}
