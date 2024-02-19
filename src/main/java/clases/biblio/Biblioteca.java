package clases.biblio;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Sergio Quiñones Majuelo
 * @date 19-02-2024
 * @version 0.2
 *
 */
public class Biblioteca {

    private int secciones;
    private String nombre;
    private String direccion;
    private int numeroDeItems;
    private int numeroDePlazas;
    private int codigo = 0; // Contador para generar identificadores únicos
    private TreeMap<Integer, Item> fondo;

    /**
     * Constructor completo de la clase Biblioteca.
     *
     * @param secciones Número de secciones de la biblioteca.
     * @param nombre Nombre de la biblioteca.
     * @param direccion Dirección de la biblioteca.
     * @param numeroDeItems Número total de ítems en la biblioteca.
     * @param numeroDePlazas Número de plazas disponibles en la biblioteca.
     * @param fondo Fondo de la biblioteca, con los ítems almacenados.
     */
    public Biblioteca(int secciones, String nombre, String direccion, int numeroDeItems, int numeroDePlazas, Map<Integer, Item> fondo) {
        this.secciones = secciones;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroDeItems = 0;
        this.numeroDePlazas = numeroDePlazas;
        this.fondo = new TreeMap<>();
        this.fondo.putAll(fondo);
    }

    public Map<Integer, Item> getFondo() {
        return fondo;
    }

    /**
     * Método para dar de alta un ítem en la biblioteca.
     *
     * @param it Ítem a dar de alta.
     * @return Mensaje indicando si se añadió correctamente el ítem.
     */
    public String altaItem(Item it) {
        fondo.put(codigo++, it);
        numeroDeItems++;
        return "Añadido correcamente";
    }

    /**
     * Método para dar de baja un ítem en la biblioteca.
     *
     * @param id Identificador único del ítem.
     * @return Un mensaje indicando si el ítem se eliminó correctamente o no se
     * encontró.
     */
    public String bajaItem(int id) {
        if (fondo.containsKey(id)) {
            fondo.remove(id);
            numeroDeItems--;
            return "Ítem eliminado correctamente";
        } else {
            return "Ítem no encontrado";
        }
    }

    /**
     * Método para obtener un listado de los libros en la biblioteca.
     *
     * @return Listado de libros en la biblioteca.
     */
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

    /**
     * Método para obtener un listado de las revistas en la biblioteca.
     *
     * @return Listado de revistas en la biblioteca.
     */
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

    /**
     * Método para obtener un listado del fondo de la biblioteca.
     *
     * @return Listado del fondo de la biblioteca.
     */
    public String listadoFondo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Listado del fondo de la biblioteca:\n");
        for (Item item : fondo.values()) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Método para obtener un listado de ítems por tema.
     *
     * @param tema Tema de los ítems a listar.
     * @return Listado de ítems por tema.
     */
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Biblioteca{\n")
                .append("  Nombre: ").append(nombre).append("\n")
                .append("  Dirección: ").append(direccion).append("\n")
                .append("  Secciones: ").append(secciones).append("\n")
                .append("  Número de plazas disponibles: ").append(numeroDePlazas).append("\n")
                .append("  Número total de ítems: ").append(numeroDeItems).append("\n")
                .append("  Fondo:\n");

        for (Item item : fondo.values()) {
            sb.append("    - ").append(item.toString()).append("\n");
        }

        sb.append("}");
        return sb.toString();
    }

}
