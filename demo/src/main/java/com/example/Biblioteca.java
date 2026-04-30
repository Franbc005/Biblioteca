package com.example;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void añadirLibro(Libro libro) {
        libros.add(libro);
    }

    public int getNumeroTotalLibros() {
        return libros.size();
    }
}
