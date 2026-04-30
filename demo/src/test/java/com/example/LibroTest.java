package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibroTest {

    private Libro libro;

    @BeforeEach
    public void setUp() {
        // Inicializamos un libro nuevo para cada test
        libro = new Libro("El Principito");
    }

    // 1. Validar estado inicial
    @Test
    public void testEstadoInicialDelLibro() {
        assertEquals("El Principito", libro.getTitulo(), "El título debe coincidir");
        assertFalse(libro.isPrestado(), "Al crearse, el libro NO debe estar prestado");
    }

    // 2. Operación prestar: Caso de éxito
    @Test
    public void testPrestarLibroCambiaEstadoCorrectamente() {
        libro.prestar();
        assertTrue(libro.isPrestado(), "El estado debería cambiar a prestado (true)");
    }

    // 3. Operación prestar: Caso de excepción
    @Test
    public void testLanzaExcepcionSiSePrestaUnLibroYaPrestado() {
        libro.prestar(); // Primera vez: éxito
        
        // Segunda vez: debe lanzar IllegalStateException
        assertThrows(IllegalStateException.class, () -> {
            libro.prestar();
        }, "Debería lanzar excepción al intentar prestar un libro ya prestado");
    }

    // 4. Operación devolver: Caso de éxito
    @Test
    public void testDevolverLibroCambiaEstadoCorrectamente() {
        libro.prestar(); // Precondición: el libro debe estar prestado
        libro.devolver();
        assertFalse(libro.isPrestado(), "El estado debería volver a no prestado (false)");
    }

    // 5. Operación devolver: Caso de excepción
    @Test
    public void testLanzaExcepcionSiSeDevuelveUnLibroNoPrestado() {
        // Intentamos devolver un libro recién creado (que no está prestado)
        assertThrows(IllegalStateException.class, () -> {
            libro.devolver();
        }, "Debería lanzar excepción al intentar devolver un libro que no ha sido prestado");
    }
}

