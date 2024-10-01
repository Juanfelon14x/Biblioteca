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

    /**
     * Metodo para verificar la existencia de un bibliotecario en la lista de bibliotecarios de la biblioteca
     * - si no hay un bibliotecario con el mismo codigo que el ingresado el centinela es false
     * - si hay un bibliotecario con el mismo codigo que el ingresado el centinela es true
     * @param cedula cedula del bibliotecario a verificar
     * @return el centinela de tipo booleano
     */
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

    /**
     * Metodo para verificar la existencia de un prestamo en la lista de prestamos de la biblioteca
     * - si no hay un prestamo con el mismo codigo que el ingresado el centinela es false
     * - si hay un prestamo con el mismo codigo que el ingresado el centinela es true
     * @param codigo codigo del prestamo a verificar
     * @return el centinela de tipo booleano
     */
    public boolean verificarPrestamo(String codigo) {
        boolean centinela = false;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                centinela = true;
            }
        }
        return centinela;
    }
/**
     * Metodo que agrega un prestamo y lo adiciona a los prestamos del estudiante y bibliotecario a los que esta asociado
     * unicamente si las siguientes condiciones se cumplen:
     * 
     * - Si el prestamo que se quiera agregar no existe en la lista de prestamos de la biblioteca
     * - Si el bibliotecario que tenga como atributo el prestamo, exista en la lista de bibliotecarios de la biblioteca
     * - Si el estudiante que tenga como atributo el prestamo exista en la lista de estudiantes de la biblioteca
     * - Si el libro de cada detalle del prestamo existe en la lista de libros de la biblioteca
     * 
     * por lo tanto antes de agregar un prestamo, los bibliotecarios, estudiantes y libros asociados se tienen que registrar en la biblioteca
     * @param prestamonuevo el prestamo que se quiera agregar
     */
    public void agregarPrestamoBiblioteca(Prestamo prestamonuevo) {

        if (verificarPrestamo(prestamonuevo.getCodigo()) == false && 
        verificarBibliotecario(prestamonuevo.getBibliotecario().getCedula()) == true &&
        verificarEstudiante(prestamonuevo.getEstudiante().getCedula()) == true)
        {
            for (DetallePrestamo detallePrestamo : prestamonuevo.getDetallePrestamos()) {
                if (verificarLibro(detallePrestamo.getLibro().getCodigo()) == true) {
                    prestamonuevo.getEstudiante().agregarPrestamoEstudiante(prestamonuevo);
                    prestamonuevo.getBibliotecario().agregarPrestamoBibliotecario(prestamonuevo);
                }
            }
            prestamos.add(prestamonuevo);
        }
    }
/**
     * 4.2
     * Metodo para entregar un prestamo, es decir, elminarlo de las listas de prestamos de estudiante y bibliotecario,
     * adicionarlo a los prestamos de historial de bibliotecario, actualizar el subtotal y sumarlo a las ganancias de la biblioteca
     * @see #eliminarPrestamoBiblioteca(Prestamo)
     * @param prestamo prestamo a entregar
     */
    public void entregarPrestamo(Prestamo prestamo){
        int total = 0;
        if (verificarPrestamo(prestamo.getCodigo()) == true) {
            for (DetallePrestamo detallePrestamo : prestamo.getDetallePrestamos()) {
                prestamo.actualizarSubtotal(detallePrestamo);
                total += detallePrestamo.getSubTotal();
            }
            eliminarPrestamoBiblioteca(prestamo);
            prestamo.getBibliotecario().agregarPrestamohistorialBibliotecario(prestamo);
            setGanancia(getGanancia() + total);
        }
    }

    /**
     * 4.3
     * Metodo para mostrar los datos de un prestamo cuyo codigo sea ingresado como parametro
     * @param codigoelegido codigo del prestamo, tipo String
     * @see #verificarPrestamo(String)
     */
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

    /**
     * 4.5
     * Metodo que genera una lista textual de todos los bibliotecarios y el numero de prestamos asociados al mismo
     * 
     * (muestra el nombre del bibliotecario por temas de prueba, aunque se puede mostrar cualquier otro atributo)
     */
    public void mostrarprestamosBibliotecarios(){
        String prestamos = "Los empleados y sus respectivos prestamos son:" + "\n";
        for(Bibliotecario bibliotecario : bibliotecarios){
            prestamos += bibliotecario.getNombre() + " = " + bibliotecario.getPrestamos().size() + "\n";
        }
        System.out.println(prestamos);
    }

    /**
     * 5.1
     * Metodo que muestra una cadena de texto con el estudiante que hizo un mayor numero de prestamos
     * y el número de prestamos realizados por el mismo
     * 
     * (muestra el nombre del estudiante por temas de prueba, aunque se puede mostrar cualquier otro atributo)
     */
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
        System.out.println("el estudiante con el mayor número de prestamos es: " + 
        estudiantemayor.getNombre() + " con " + prestamomayor + " prestamos");    
    }

    /**
     * Metodo para actualizar las ganancias totales resultantes de hacerle el pago a los bibliotecarios
     */
    public void actualizarganancia(){
        setDeuda(dineroapagarbibliotecarios());
        setGanancia(getGanancia() - getDeuda());
    }


    /**
     * 5.3
     * Metodo que retorna el total de dinero a pagar a todos los bibliotecarios 
     * 
     * @bonificacion1 es el dinero que se le da al bibliotecario, el cuál es el 20% de cada subtotal del
     * detalle de prestamo de cada prestamo
     * 
     * @bonificacion2 es la bonificacion1 más un 0.2% por cada año de antiguedad que tenga el bibliotecario
     * 
     * @dineroapagar es la bonificacion 2 sumada sucesivamente para dar un unico valor totalizado
     * 
     * @return dineroapagar
     */
    public double dineroapagarbibliotecarios(){
        double bonificacion1 = 0;
        double bonificacion2 = 0;
        double dineroapagar = 0;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            for (Prestamo prestamo : bibliotecario.getPrestamoshistorial()) {
                for (DetallePrestamo detallePrestamo : prestamo.getDetallePrestamos()) {
                    prestamo.actualizarSubtotal(detallePrestamo);
                    bonificacion1 = 0.2 * detallePrestamo.getSubTotal();
                    bonificacion2 = bonificacion1 + (0.02 * bibliotecario.getAntiguedad());
                    dineroapagar += bonificacion2;
                }
            }
        }
        return dineroapagar;
    }
}
