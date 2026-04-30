package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {

    private Libro libro;
    private Biblioteca biblioteca;

    @BeforeEach
    public void setUp() {
        // Esto se ejecuta antes de cada @Test, asegurando un estado limpio
        libro = new Libro("Cien años de soledad");
        biblioteca = new Biblioteca();
    }

    @Test
    public void testLibroCreadoCorrectamente() {
        assertEquals("Cien años de soledad", libro.getTitulo());
        assertFalse(libro.isPrestado(), "El libro no debería estar prestado al inicio");
    }

    @Test
    public void testPrestarLibroCambiaEstado() {
        libro.prestar();
        assertTrue(libro.isPrestado());
    }

    @Test
    public void testPrestarLibroYaPrestadoLanzaExcepcion() {
        libro.prestar();
        // Verificamos que lance IllegalStateException
        assertThrows(IllegalStateException.class, () -> {
            libro.prestar();
        });
    }

    @Test
    public void testAñadirLibrosABiblioteca() {
        biblioteca.añadirLibro(libro);
        biblioteca.añadirLibro(new Libro("Rayuela"));
        assertEquals(2, biblioteca.getNumeroTotalLibros());
    }
}