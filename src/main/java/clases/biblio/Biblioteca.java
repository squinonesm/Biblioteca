package clases.biblio;

import java.util.Map;

/**
 *
 * @author Sergio Quiñones Majuelo
 * @date 15-02-2024
 * @version 0.1
 *
 */
public class Biblioteca {

    private int secciones;
    private String nombre;
    private String direccion;
    private int numeroDeItems;
    private int numeroDePlazas;
    private Map<String, Item> fondo;

    //Constructor completo de la clase biblioteca
    public Biblioteca(int secciones, String nombre, String direccion, int numeroDeItems, int numeroDePlazas, Map<String, Item> fondo) {
        this.secciones = secciones;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroDeItems = numeroDeItems;
        this.numeroDePlazas = numeroDePlazas;
        this.fondo = fondo;
    }

    public String altaItem(String codigo, Item it) {

        fondo.put(codigo, it);
        return "Añadido correcamente";
    }

    public String bajaItem(String codigo, Item it) {
        fondo.remove(codigo);
        return ("Item eliminado correcamente");
    }

    public String listadoDeLibros() {
        StringBuilder sb = new StringBuilder();
        sb.append("Listado de libros:\n");
        for (Item item : fondo.values()) {
            if (item instanceof Libro) {
                sb.append(((Libro) item).toString()).append("\n");
            }
        }
        return sb.toString();
    }

    public String listadoDeRevistas() {
        StringBuilder sb = new StringBuilder();
        sb.append("Listado de revistas:\n");
        for (Item item : fondo.values()) {
            if (item instanceof Revista) {
                sb.append(((Revista) item).toString()).append("\n");
            }
        }
        return sb.toString();
    }

    public String listadoFondo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Listado del fondo de la biblioteca:\n");
        for (Item item : fondo.values()) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }

    public String listadoPorTema(String tema) {
        StringBuilder sb = new StringBuilder();
        sb.append("Listado de items por tema '").append(tema).append("':\n");
        for (Item item : fondo.values()) {
            if (item.getTematica().equals(tema)) {
                sb.append(item.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
