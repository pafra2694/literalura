package com.pafradev.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Authors(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") Integer anoNacimiento,
        @JsonAlias("death_year") Integer anoMuerte
) {
    @Override
    public String toString() {
        return nombre;
    }
}
