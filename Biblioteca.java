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

    /**
     * Metodo para agregar un libro ingresado si no existe en la lista de libros de la biblioteca
     * @param libro un libro que no esté en la base de datos de la biblioteca
     * @see #reemplazarLibro(Libro, Libro)
     */
    public void agregarLibro(Libro libro) {
        if (verificarLibro(libro.getCodigo()) == false) {
            libros.add(libro);
            setCantidadLibros(getCantidadLibros()+1);
        }
    }
    /**
     * Metodo para eliminar un libro ingresado si existe en la lista de libros de la biblioteca
     * @param libro un libro que esté en la base de datos de la biblioteca
     */
    public void eliminarLibro(Libro libro) {
        if (verificarLibro(libro.getCodigo()) == true) {
            libros.remove(libro);
            setCantidadLibros(getCantidadLibros()-1);
        }
    }
//----------------------------------Gestion parcial-----------------------------------//
    /**
    * 3.2
    * Mostrar los datos de un libro dado su codigo
    * @param codigoelegido codigo a consultar
    * @see #mostrarprestamoslibro(String)
    */
    public void mostrardatoslibro(String codigoelegido){
        String mensaje = "";
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigoelegido)) {
                mensaje = libro.toString();
                break;
            }
        }
        System.out.println(mensaje);
    }

    /**
    * 3.3
    * Mostrar el numero de prestamos en los que está involucrado un libro dado su titulo
    * @param tituloelegido titulo del libro a consultar
    * @see #mostrardatoslibro(String)
    */
    public void mostrarprestamoslibro(String tituloelegido){
        int contador = 0;
        for (Prestamo prestamo : prestamos) {
            for (DetallePrestamo detallePrestamo : prestamo.getDetallePrestamos()) {
                if (detallePrestamo.getLibro().getTitulo().equals(tituloelegido)) {
                    contador++;
                }
            }
        }
        System.out.println("El libro de titulo " + tituloelegido + " está en " + contador + " prestamos\n");
    }
    
    /**
     * 3.4
     * Metodo alternativo para agregar un libro, sobreescribiendolo en la posicion de otro
     * @param libronuevo un libro que no esté en la base de datos de la biblioteca
     * @param libroacambiar un libro existente a intercambiar
     * @see #agregarLibro(Libro)
     */
    public void reemplazarLibro(Libro libronuevo, Libro libroacambiar){
        libros.set(libros.indexOf(libroacambiar), libronuevo);
    }
//--------------------------------------------------Estudiante-----------------------------------------------------//
/**
     * Metodo para verificar la existencia de un estudiante en la lista de estudiantes de la biblioteca
     * - si no hay un estudiante con el mismo codigo que el ingresado el centinela es false
     * - si hay un estudiante con el mismo codigo que el ingresado el centinela es true
     * @param cedula cedula del estudiante a verificar
     * @return el centinela de tipo booleano
     */
    public boolean verificarEstudiante(String cedula) {
        boolean centinela = false;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }
/**
     * Metodo para agregar un estudiante verificando que no exista
     * @param estudiante estudiante a agregar
     */
    public void agregarEstudiante(Estudiante estudiante) {
        if (verificarLibro(estudiante.getCedula()) == false) {
            estudiantes.add(estudiante);
        }
    }
/**
     * Metodo para eliminar un estudiante verificando que exista
     * @param estudiante estudiante a eliminar
     */
    public void eliminarEstudiante(Estudiante estudiante) {
        if (verificarLibro(estudiante.getCedula()) == true) {
            estudiantes.remove(estudiante);
        }
    }
