package clases.biblio;

import java.util.GregorianCalendar;

/**
 *
 * @author Sergio Quiñones Majuelo
 * @date 14-02-2024
 * @version 0.1
 *
 */
public class Revista extends Item {

    private String numRevista;
    private String tipoAdjunto;

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
                + ", estaPrestado=" + estaPrestado
                + ", tematica='" + tematica + '\''
                + '}';
    }

}
