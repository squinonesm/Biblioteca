package clases.biblio;

import java.util.ArrayList;

/**
 *
 * @author Sergio Quiñones Majuelo
 * @date 14-02-2024
 * @version 0.1
 *
 */
public class Usuario {

    private String nombreCompleto;
    private String DNI;
    private int numSocio;
    private int tlf;
    private ArrayList<Item> librosPrestados;
    private boolean estaSancionado;

    public Usuario(String nombreCompleto, String DNI, int numSocio, int tlf, ArrayList<Item> librosPrestados, boolean sancionado) {
        this.nombreCompleto = nombreCompleto;
        this.DNI = DNI;
        this.numSocio = numSocio;
        this.tlf = tlf;
        this.librosPrestados = new ArrayList<Item>();
        this.estaSancionado = false;
    }

    public String tomarItemPrestado(Item it) {

        if (librosPrestados.size() >= 5) {
            return "Número máximo de libros alcanzado";
        } else if (it.getEstaPrestado()) {
            return "El libro ya está prestado a otro usuario";
        } else {
            librosPrestados.add(it);
            it.setEstaPrestado(true);
            return "Libro disponible y añadido al usuario";
        }
    }

    public String devolverItem(Item it) {

        librosPrestados.remove(it);
        it.setEstaPrestado(false);
        return "Libro devuelto correctamente";
    }

    public String listadoDeItems() {
        StringBuilder aux = new StringBuilder();
        aux.append("Listado de libros prestados a ").append(nombreCompleto).append(":\n");
        aux.append("----------------------------------------------\n");
        for (Item libro : librosPrestados) {
            aux.append(String.format("%-20s %-20s %-20s\n", libro.titulo, libro.editorial, libro.fecha.getTime().toString()));
        }

        return aux.toString();
    }

}
