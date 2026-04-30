package com.example;

public class Libro {
    private String titulo;
    private boolean prestado;

    public Libro(String titulo) {
        this.titulo = titulo;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void prestar() {
        if (this.prestado) {
            throw new IllegalStateException("El libro ya está prestado.");
        }
        this.prestado = true;
    }

    public void devolver() {
        if (!this.prestado) {
            throw new IllegalStateException("El libro no está prestado.");
        }
        this.prestado = false;
    }
    public static void main(String[] args) {
        Biblioteca miBiblioteca = new Biblioteca();
        Libro libro1 = new Libro("Cien años de soledad");

        miBiblioteca.añadirLibro(libro1);
        System.out.println("Libros en biblioteca: " + miBiblioteca.getNumeroTotalLibros());

        libro1.prestar();
        System.out.println("¿Está prestado?: " + libro1.isPrestado());
    }
}


