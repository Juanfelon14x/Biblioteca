import java.util.LinkedList;
import java.time.LocalDate;
public class app {
    public static void main(String[] args) {
        Biblioteca biblioteca1 = new Biblioteca("Mundopapel", 0, 0, 0);

        for (int i = 0; i < 5; i++){
            Estudiante estudiantei = new Estudiante("Estudiante"+i, "00000"+i,
            "Estudiante"+i+"@gmail.com", 111*(i+1), 20+i);
            biblioteca1.agregarEstudiante(estudiantei);

            Bibliotecario bibliotecarioi = new Bibliotecario("Bibliotecario"+i, "11111"+i,
            "Bibliotecario"+i+"@gmail.com",111*(i+6), 1000000*(i+1), i+1);
            biblioteca1.agregarBibliotecario(bibliotecarioi);

            for (int j = 0; j < 2; j++){ 
                int g = ((2*i)+j+1);
                LocalDate fechapublicacionlibrog = LocalDate.of(2016, 4, 5);

                Libro librog = new Libro("2222"+ g, "456456"+g, "Autor"+g, 
                "Editorial"+g, "Libro"+ g, fechapublicacionlibrog, true,
                30+i);


                DetallePrestamo detallePrestamoj = new DetallePrestamo(3, librog);

                LocalDate fechaprestamog = LocalDate.of(2024,10,16);
                LocalDate fechaentregag = LocalDate.of(2024,11,16);

                Prestamo prestamog = new Prestamo(fechaprestamog, fechaentregag,
                50, "546476"+g, biblioteca1, estudiantei, bibliotecarioi);

                prestamog.agregarDetallePrestamo(detallePrestamoj);
                biblioteca1.agregarLibro(librog);
                biblioteca1.agregarPrestamoBiblioteca(prestamog);
                biblioteca1.entregarPrestamo(prestamog);
            
            LocalDate   fechapublicacionlibro1 = LocalDate.of(2024, 5, 6);
            Libro libro1= new Libro("2342", "234563", "juan valdez", "planeta", "quijote", fechapublicacionlibro1, false, 24);
            biblioteca1.agregarLibro(libro1);            
            biblioteca1.verificarLibro("2342");
            biblioteca1.mostrardatoslibro("2342");
            biblioteca1.mostrarprestamoslibro("quijote");
            biblioteca1.reemplazarLibro(librog, libro1);
            
            
            }
            System.out.println(bibliotecarioi);
        }
        System.out.println(biblioteca1);
        System.out.println(biblioteca1.dineroapagarbibliotecarios());
        biblioteca1.actualizarganancia();
        System.out.println(biblioteca1.getGanancia());
    }
}
    }
    
}
