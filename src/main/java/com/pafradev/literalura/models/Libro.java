package com.pafradev.literalura.models;

import com.pafradev.literalura.dto.BookData;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Autor autor;

    private String idioma;

    private Integer numeroDescargas;

    public Libro(){}

    public Libro(BookData bookData, Autor a){
        this.titulo = bookData.titulo();
        this.autor = a;
        this.idioma = bookData.idiomas().get(0).toString();
        this.numeroDescargas = bookData.numeroDescargas();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Integer numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    @Override
    public String toString() {
        return "\n---------------- Libro ---------------- \n" +
                "Titulo= " + titulo + "\n"+
                "Autor=" + autor.getNombre() + "\n"+
                "Idioma=" + idioma + "\n" +
                "Numero de descargas= " + numeroDescargas +
                "\n--------------------------------------- \n";
    }
}
