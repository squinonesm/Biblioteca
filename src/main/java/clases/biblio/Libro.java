package clases.biblio;

import java.util.GregorianCalendar;

/**
 *
 * @author Sergio Quiñones Majuelo
 * @date 14-02-2024
 * @version 0.1
 *
 */
public class Libro extends Item {

    private String autorLibro;
    private String ISBN;

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
                + ", estaPrestado=" + estaPrestado
                + ", tematica='" + tematica + '\''
                + '}';
    }

}
