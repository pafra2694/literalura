package com.pafradev.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BooksData(
        @JsonAlias("count") Integer conteo,
        @JsonAlias("results") List<BookData> resultados
) {
}
