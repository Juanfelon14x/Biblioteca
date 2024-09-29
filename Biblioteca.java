package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

public class Biblioteca {

    private String nombre;
    private LinkedList<Estudiante> estudiantes;
    private LinkedList<Bibliotecario> bibliotecarios;
    private LinkedList<Prestamo> prestamos;
    private LinkedList<Libro> libros;
    private double ganancia = 0;
    private double deuda = 0;
    private int cantidadLibros = 0;
/**
     * Constructor de la clase biblioteca para inicializar sus atributos
     * @param nombre nombre de la biblioteca
     * @param ganancia ganancias de la biblioteca
     * @param cantidadLibros cantidad de libros de la biblioteca
     */
    public Biblioteca(String nombre, double ganancia, double deuda, int cantidadLibros) {
        this.nombre = nombre;
        this.ganancia = ganancia;
        this.deuda = deuda;
        this.cantidadLibros = cantidadLibros;
        estudiantes = new LinkedList<>();
        bibliotecarios = new LinkedList<>();
        prestamos = new LinkedList<>();
        libros = new LinkedList<>();
    }
}
