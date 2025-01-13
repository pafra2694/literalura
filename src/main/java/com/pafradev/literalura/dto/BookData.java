package com.pafradev.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<Authors> autores,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Integer numeroDescargas
) {

    @Override
    public String toString() {
        return "\n---------------- Libro ---------------- \n" +
                "Titulo= "+ titulo + "\n" +
                "Autor= " + autores.get(0) + "\n" +
                "Idioma= " + idiomas.get(0) + "\n" +
                "Numero de descargas= " + numeroDescargas+
                "\n--------------------------------------- \n";
    }
}
