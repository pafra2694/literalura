package com.pafradev.literalura.services;

public interface IConvertData {
    <T> T obtenerDatos(String json, Class<T> clase);
}
