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

    /**
     *  Getters y Setters de la clase biblioteca
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(LinkedList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public LinkedList<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public void setBibliotecarios(LinkedList<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    public LinkedList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(LinkedList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public LinkedList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(LinkedList<Libro> libros) {
        this.libros = libros;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

  /**
     * toString de la clase biblioteca, en donde, en lugar de mostrar cada lista de sus atributos, muestra
     * la cantidad de elementos de estas, por cuestion de pruebas y con el fin de evitar un error ciclico
     * que muestra los las listas anidadas de las listas de forma indefinida
     */
    @Override
    public String toString() {
        return "\n\nBiblioteca [nombre=" + nombre + ", estudiantes=" + estudiantes.size() + ", bibliotecarios=" + bibliotecarios.size()
                + ", prestamos=" + prestamos.size() + ", libros=" + libros.size() + ", ganancia=" + ganancia + ", cantidadLibros="
                + cantidadLibros + "]";
    }

//---------------------------------------------------Libros--------------------------------------------------------//
//----------------------------------Gestion global-----------------------------------//

    /**
     * Metodo para verificar la existencia de un libro en la lista de libros de la biblioteca
     * - si no hay un libro con el mismo codigo que el ingresado el centinela es false
     * - si hay un libro con el mismo codigo que el ingresado el centinela es true
     * @param codigo codigo del libro a verificar
     * @return el centinela de tipo booleano
     */
    public boolean verificarLibro(String codigo) {
        boolean centinela = false;
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                centinela = true;
            }
        }
        return centinela;
    }
}
