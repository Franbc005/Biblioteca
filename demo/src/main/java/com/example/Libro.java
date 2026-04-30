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

    public boolean siPrestado() {
        return prestado;
    }

    public void prestar() {
        if (this.prestado) {
            throw new IllegalMonitorStateException("El libro ya está prestado.");
        }
        this.prestado = true;
    }

    public void devolver() {
        if (!this.prestado) {
            throw new IllegalMonitorStateException("El libro no está prestado.");
        }
        this.prestado = false;
    }
}


