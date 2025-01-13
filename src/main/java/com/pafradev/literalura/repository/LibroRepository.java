package com.pafradev.literalura.repository;

import com.pafradev.literalura.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query("SELECT l FROM Libro l WHERE l.idioma = :idiomaBusqueda")
    List<Libro> obtenerLibrosPorIdioma(String idiomaBusqueda);
}
