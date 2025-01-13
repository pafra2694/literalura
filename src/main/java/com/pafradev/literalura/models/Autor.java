package com.pafradev.literalura.models;

import com.pafradev.literalura.dto.Authors;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer fechaNacimiento;

    private Integer fechaFallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(){};

    public Autor(Authors autor){
        this.nombre = autor.nombre();
        this.fechaNacimiento = autor.anoNacimiento();
        this.fechaFallecimiento = autor.anoMuerte();
    }

    @Override
    public String toString() {

        StringBuilder librosString = new StringBuilder();
        for (Libro libro : libros) {
            librosString.append(libro.getTitulo()).append(", ");
        }

        // Eliminar la última coma y espacio
        if (librosString.length() > 0) {
            librosString.setLength(librosString.length() - 2);
        }

        return "Autor= " + nombre + "\n" +
                "Fecha de nacimiento= " + fechaNacimiento + "\n" +
                "Fecha de fallecimiento= " + fechaFallecimiento + "\n" +
                "Libros= " + librosString + "\n\n";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Integer fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
