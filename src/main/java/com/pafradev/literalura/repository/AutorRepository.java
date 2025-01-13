package com.pafradev.literalura.repository;

import com.pafradev.literalura.models.Autor;
import com.pafradev.literalura.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNombre(String nombre);

    @Query("SELECT a FROM Autor a WHERE a.fechaNacimiento <= :year AND (a.fechaFallecimiento > :year OR a.fechaFallecimiento IS NULL)")
    List<Autor> obtenerAutoresVivosAnio(Integer year);

}
