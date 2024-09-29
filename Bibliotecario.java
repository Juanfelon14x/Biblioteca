package co.edu.uniquindio.poo;
import java.util.Collection;
import java.util.LinkedList;

public class Bibliotecario extends Persona {

    private double salario;
    private int antiguedad;
    private Collection<Prestamo> prestamos;
    private Collection<Prestamo> prestamoshistorial;
    
     /**
     * Constructor para inicializar los atributos de la clase bibliotecario, la cual extiende de la clase persona
     * @param nombre
     * @param cedula
     * @param correo
     * @param telefono
     * @param salario
     * @param antiguedad
     */
    public Bibliotecario(String nombre, String cedula, String correo, int telefono, double salario, int antiguedad) {
        super(nombre, cedula, correo, telefono);
        this.salario = salario;
        this.antiguedad = antiguedad;
        prestamos = new LinkedList<>();
        prestamoshistorial = new LinkedList<>();
    }
    /**
     *  Getters y Setters de la clase bibliotecario
     */
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
    public Collection<Prestamo> getPrestamoshistorial() {
        return prestamoshistorial;
    }

    public void setPrestamoshistorial(Collection<Prestamo> prestamoshistorial) {
        this.prestamoshistorial = prestamoshistorial;
    }
     /**
     * toString de la clase bibliotecario, con un llamado al toString de la clase super persona
     * para mostrar los tados completos, en lugar de mostrar cada lista de sus atributos, muestra
     * la cantidad de elementos de estas, por cuestion de pruebas y con el fin de evitar un error ciclico
     * que muestra los las listas anidadas de las listas de forma indefinida
     */
    @Override
    public String toString() {
        return "\nBibliotecario ["+ super.toString() + "salario=" + salario + ", antiguedad=" + antiguedad +
        ", prestamos=" + prestamos + "]";
    }
    
//--------------------------------------------------Prestamos-------------------------------------------------------//
     /**
     * Metodo para agregar un prestamo a los prestamos de historial de un bibliotecario
     * @param prestamo
     */
    public void agregarPrestamoBibliotecario(Prestamo prestamo) {
        prestamos.add(prestamo);
    }
    /**
     * Metodo para eliminar un prestamo a los prestamos de un bibliotecario
     * @param prestamo
     */
    public void eliminarPrestamoBibliotecario(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }
     /**
     * Metodo para agregar un prestamo a los prestamos de historial de un bibliotecario
     * @param prestamo
     */
    public void agregarPrestamohistorialBibliotecario(Prestamo prestamo) {
        prestamoshistorial.add(prestamo);
    }
    /**
     * Metodo para eliminar un prestamo a los prestamos de historial de un bibliotecario
     * @param prestamo
     */
    public void eliminarPrestamohistorialBibliotecario(Prestamo prestamo) {
        prestamoshistorial.remove(prestamo);
    }
}
