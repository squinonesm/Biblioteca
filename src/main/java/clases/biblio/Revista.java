package clases.biblio;

import java.util.GregorianCalendar;

/**
 *
 * @author Sergio Quiñones Majuelo
 * @date 19-02-2024
 * @version 0.2
 *
 */
public class Revista extends Item {

    private String numRevista;
    private String tipoAdjunto;

    /**
     * Constructor de la clase Revista.
     *
     * @param numRevista Número de la revista.
     * @param tipoAdjunto Tipo de adjunto de la revista.
     * @param titulo Título de la revista.
     * @param numeroPaginas Número de páginas de la revista.
     * @param editorial Editorial de la revista.
     * @param fecha Fecha de publicación de la revista.
     * @param estaPrestado Indica si la revista está prestada.
     * @param tematica Temática de la revista.
     */
    public Revista(String numRevista, String tipoAdjunto, String titulo, short numeroPaginas, String editorial, GregorianCalendar fecha, boolean estaPrestado, String tematica) {
        super(titulo, numeroPaginas, editorial, fecha, estaPrestado, tematica);
        this.numRevista = numRevista;
        this.tipoAdjunto = tipoAdjunto;
    }

    @Override
    public String toString() {
        return "Revista{"
                + "titulo='" + titulo + '\''
                + ", número='" + numRevista + '\''
                + ", adjunto='" + tipoAdjunto + '\''
                + ", numeroPaginas=" + numeroPaginas
                + ", editorial='" + editorial + '\''
                + ", fecha=" + fecha.getTime().toString()
                + ", estaPrestado=" + (estaPrestado ? "Sí" : "No")
                + ", tematica='" + tematica + '\''
                + '}';
    }

}
