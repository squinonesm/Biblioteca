package clases.biblio;
import java.util.GregorianCalendar;

/**
 *
 * @author Sergio Quiñones Majuelo
 * @date 14-02-2024
 * @version 0.1
 *
 */
public class Item {
    
    protected String titulo;
    protected short numeroPaginas;
    protected String editorial;
    protected GregorianCalendar fecha;
    protected boolean estaPrestado;
    protected String tematica;

    //Constructor Completo
    public Item(String titulo, short numeroPaginas, String editorial, GregorianCalendar fecha, boolean estaPrestado, String tematica) {
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
        this.editorial = editorial;
        this.fecha = fecha;
        this.estaPrestado = estaPrestado;
        this.tematica = tematica;
    }

    public String getTematica() {
        return tematica;
    }

    public void setEstaPrestado(boolean estaPrestado) {
        this.estaPrestado = estaPrestado;
    }

    public boolean getEstaPrestado() {
        return estaPrestado;
    }
    
}
