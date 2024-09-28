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
    private double ganancia;
    private int cantidadLibros;

    public Biblioteca(String nombre, double ganancia, int cantidadLibros) {
        this.nombre = nombre;
        this.ganancia = ganancia;
        this.cantidadLibros = cantidadLibros;
        estudiantes = new LinkedList<>();
        bibliotecarios = new LinkedList<>();
        prestamos = new LinkedList<>();
        libros = new LinkedList<>();
    }

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

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    @Override
    public String toString() {
        return "\n\nBiblioteca [nombre=" + nombre + ", estudiantes=" + estudiantes + ", bibliotecarios=" + bibliotecarios
                + ", prestamos=" + prestamos + ", libros=" + libros + ", ganancia=" + ganancia + ", cantidadLibros="
                + cantidadLibros + "]";
    }
//---------------------------------------------------Libros--------------------------------------------------------//
//----------------------------------Gestion global-----------------------------------//

    public boolean verificarLibro(String codigo) {
        boolean centinela = false;
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                centinela = true;
            }
        }
        return centinela;
    }
    public void agregarLibro(Libro libro) {
        if (verificarLibro(libro.getCodigo()) == false) {
            libros.add(libro);
            setCantidadLibros(+1);
        }
    }
    public void eliminarLibro(Libro libro) {
        if (verificarLibro(libro.getCodigo()) == true) {
            libros.remove(libro);
            setCantidadLibros(-1);
        }
    }
//----------------------------------Gestion parcial-----------------------------------//
    /*
    * 3.2
    * Mostrar los datos de un libro dado su codigo
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

    /*
    * 3.3
    * Mostrar el numero de prestamos en los que está involucrado un libro dado su titulo
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
        System.out.println(contador);
    }
    /**
     * 3.4
     * Metodo alternativo para agregar un libro, sobreescribiendolo en la posicion de otro
     * @param libronuevo un libro que no esté en la base de datos de la biblioteca
     * @param libroacambiar un libro existente a eliminar
     */
    public void reemplazarLibro(Libro libronuevo, Libro libroacambiar){
        libros.set(libros.indexOf(libroacambiar), libronuevo);
    }

//--------------------------------------------------Estudiante-----------------------------------------------------//

    public boolean verificarEstudiante(String cedula) {
        boolean centinela = false;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }
    public void agregarEstudiante(Estudiante estudiante) {
        if (verificarLibro(estudiante.getCedula()) == false) {
            estudiantes.add(estudiante);
        }
    }
    public void eliminarEstudiante(Estudiante estudiante) {
        if (verificarLibro(estudiante.getCedula()) == true) {
            estudiantes.remove(estudiante);
        }
    }
//------------------------------------------------Bibliotecario---------------------------------------------------//

    public boolean verificarBibliotecario(String cedula) {
        boolean centinela = false;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }
    public void agregarBibliotecario(Bibliotecario bibliotecario) {
        if (verificarLibro(bibliotecario.getCedula()) == false) {
            bibliotecarios.add(bibliotecario);
        }
    }
    public void eliminarBibliotecario(Bibliotecario bibliotecario) {
        if (verificarLibro(bibliotecario.getCedula()) == true) {
            bibliotecarios.remove(bibliotecario);
        }
    }
//---------------------------------------------------Prestamo-----------------------------------------------------//

    public boolean verificarPrestamo(String codigo) {
        boolean centinela = false;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                centinela = true;
            }
        }
        return centinela;
    }
    /*
     * Metodo que, ya habiendo creado un prestamo, hace efectiva la agregacion del estudiante y 
     */
    public void agregarPrestamoBiblioteca(Prestamo prestamonuevo) {
        if (verificarPrestamo(prestamonuevo.getCodigo()) == false) {
            prestamonuevo.getEstudiante().agregarPrestamoEstudiante(prestamonuevo);
            prestamonuevo.getBibliotecario().agregarPrestamoBibliotecario(prestamonuevo);
            agregarEstudiante(prestamonuevo.getEstudiante());
            agregarBibliotecario(prestamonuevo.getBibliotecario());
            prestamos.add(prestamonuevo);
        }
    }
    public void eliminarPrestamoBiblioteca(Prestamo prestamo) {
        if (verificarPrestamo(prestamo.getCodigo()) == true) {
            prestamos.remove(prestamo);
            prestamo.getEstudiante().eliminarPrestamoEstudiante(prestamo);
            prestamo.getBibliotecario().eliminarPrestamoBibliotecario(prestamo);
            eliminarEstudiante(prestamo.getEstudiante());
            eliminarBibliotecario(prestamo.getBibliotecario());
        }
    }
    /*
     * Metodo para entregar un prestamo, es decir, elminarlo de todas las listas en donde esté,
     * actualizar el subtotal y sumarlo a las ganancias de la biblioteca
     */
    public void entregarPrestamo(Prestamo prestamobuscado){
        int total = 0;
        for (DetallePrestamo detallePrestamo : prestamobuscado.getDetallePrestamos()) {
            prestamobuscado.actualizarSubtotal(detallePrestamo);
            total += getGanancia();
        }
        setGanancia(getGanancia() + total);
        prestamos.remove(prestamobuscado);
        prestamobuscado.getEstudiante().eliminarPrestamoEstudiante(prestamobuscado);
        prestamobuscado.getBibliotecario().eliminarPrestamoBibliotecario(prestamobuscado);
    }
    public void mostrardatosPrestamo(String codigoelegido){
        String mensaje = "";
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigoelegido)) {
                mensaje = prestamo.toString();
                break;
            }
        }
        System.out.println(mensaje);
    }
    public void mostrarprestamosBibliotecarios(){
        String prestamos = "Los empleados que han adquirido prestamos son:" + "\n";
        for(Bibliotecario bibliotecario : bibliotecarios){
            prestamos += bibliotecario.getNombre() + " = " + bibliotecario.getPrestamos().size() + "\n";
        }
        System.out.println(prestamos);
    }
    public void estudianteconmasprestamos(){
        int prestamomayor = 0;
        Estudiante estudiantemayor = null;
        for (Estudiante estudiante : estudiantes) {
            int contador = 0;
            contador = estudiante.getPrestamos().size();

            if (contador > prestamomayor) {
                estudiantemayor = estudiante;
                prestamomayor = contador;
            }
        }
        System.out.println("el estudiante" + estudiantemayor + "hizo" + prestamomayor + "prestamos");    
    }
    public void dineroapagarbibliotecarios(){
        double dineroapagar = 0;
        double bonificacion1 = 0;
        double bonificacion2 = 0;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            for (Prestamo prestamo : bibliotecario.getPrestamos()) {
                for (DetallePrestamo detallePrestamo : prestamo.getDetallePrestamos()) {
                    prestamo.actualizarSubtotal(detallePrestamo);
                    bonificacion1 = 0.2 * detallePrestamo.getSubTotal();
                    bonificacion2 = bonificacion1 + (0.02 * bibliotecario.getAntiguedad());
                    dineroapagar += bonificacion2;
                }
            }
        }
        System.out.println("El dinero total a pagar a todos los bibliotecarios es" + dineroapagar);
    }


    public static void main(String[] args) {

        //-----------------------------------------Crearvariables----------------------------------------//

        Biblioteca biblioteca1 = new Biblioteca("Libros libreros", 0, 0);

        Estudiante estudiante1 = new Estudiante("Richard", "2354345",
        "Rich43@gmail.com", 35445654, 21);

        Bibliotecario bibliotecario1 = new Bibliotecario("Esteban", "3654534",
        "Est2423@gmail.com",435464576, 500000, 35);

            LocalDate fechapublicacionlibro1 = LocalDate.of(2016, 4, 5);

        Libro libro1 = new Libro("3546436", "456456", "Ramiro del valle", 
        "Mundopapel", "Libro1", fechapublicacionlibro1, true,
        40);

            LocalDate fechaprestamo1 = LocalDate.of(2024,10,16);
            LocalDate fechaentrega1 = LocalDate.of(2024,11,16);


        Prestamo prestamo1 = new Prestamo(fechaprestamo1, fechaentrega1,
        50, "546476", biblioteca1, estudiante1, bibliotecario1);
        
        DetallePrestamo detallePrestamo1 = new DetallePrestamo(3, libro1);

        //--------------------------------------------Gestionar-------------------------------------------//

        biblioteca1.agregarPrestamoBiblioteca(prestamo1);
        prestamo1.agregarDetallePrestamo(detallePrestamo1);

        
        System.out.println(biblioteca1);
    }
}
