package clases.biblio;

import java.util.GregorianCalendar;

/**
 *
 * @author Sergio Quiñones Majuelo
 * @date 19-02-2024
 * @version 0.2
 *
 */
public class Libro extends Item {

    private String autorLibro;
    private String ISBN;

    /**
     * Constructor de la clase Libro.
     *
     * @param autorLibro El autor del libro
     * @param ISBN El número de ISBN del libro
     * @param titulo El título del libro
     * @param numeroPaginas El número de páginas del libro
     * @param editorial La editorial del libro
     * @param fecha La fecha de publicación del libro
     * @param estaPrestado Indica si el libro está prestado actualmente o no
     * @param tematica La temática del libro
     */
    public Libro(String autorLibro, String ISBN, String titulo, short numeroPaginas, String editorial, GregorianCalendar fecha, boolean estaPrestado, String tematica) {
        super(titulo, numeroPaginas, editorial, fecha, estaPrestado, tematica);
        this.autorLibro = autorLibro;
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Libro{"
                + "titulo='" + titulo + '\''
                + ", autor='" + autorLibro + '\''
                + ", ISBN='" + ISBN + '\''
                + ", numeroPaginas=" + numeroPaginas
                + ", editorial='" + editorial + '\''
                + ", fecha=" + fecha.getTime().toString()
                + ", estaPrestado=" + (estaPrestado ? "Sí" : "No")
                + ", tematica='" + tematica + '\''
                + '}';
    }

}
