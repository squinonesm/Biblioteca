package clases.biblio;

import java.util.ArrayList;

/**
 *
 * @author Sergio Quiñones Majuelo
 * @date 19-02-2024
 * @version 0.2
 *
 */
public class Usuario {

    private String nombreCompleto;
    private String DNI;
    private int numSocio;
    private int tlf;
    private ArrayList<Item> librosPrestados;
    private boolean estaSancionado;

    /**
     * Constructor de la clase Usuario.
     *
     * @param nombreCompleto Nombre completo del usuario.
     * @param DNI Número de documento de identidad del usuario.
     * @param numSocio Número de socio del usuario.
     * @param tlf Número de teléfono del usuario.
     * @param librosPrestados Lista de libros prestados al usuario.
     * @param sancionado Indica si el usuario está sancionado.
     */
    public Usuario(String nombreCompleto, String DNI, int numSocio, int tlf, ArrayList<Item> librosPrestados, boolean sancionado) {
        this.nombreCompleto = nombreCompleto;
        this.DNI = DNI;
        this.numSocio = numSocio;
        this.tlf = tlf;
        this.librosPrestados = librosPrestados; // Asignar la lista proporcionada
        this.estaSancionado = sancionado; // Usar el valor proporcionado
    }

    /**
     * Método para tomar un item prestado.
     *
     * @param it Item que se va a tomar prestado.
     * @return Mensaje indicando si se pudo tomar prestado el item.
     */
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

    /**
     * Método para devolver un item prestado.
     *
     * @param it Item que se va a devolver.
     * @return Mensaje indicando si se pudo devolver el item.
     */
    public String devolverItem(Item it) {

        librosPrestados.remove(it);
        it.setEstaPrestado(false);
        return "Libro devuelto correctamente";
    }

    /**
     * Método para obtener un listado de los items prestados.
     *
     * @return Listado de los items prestados al usuario.
     */
    public String listadoDeItems() {
        StringBuilder aux = new StringBuilder();
        aux.append("Listado de libros prestados a ").append(nombreCompleto).append(":\n");
        aux.append("----------------------------------------------\n");
        for (Item libro : librosPrestados) {
            aux.append(String.format("%-20s %-20s %-20s\n", libro.titulo, libro.editorial, libro.fecha.getTime().toString()));
        }

        return aux.toString();
    }

    @Override
    public String toString() {
        StringBuilder librosPrestadosStr = new StringBuilder();
        librosPrestadosStr.append("Libros Prestados:\n");
        for (Item item : librosPrestados) {
            librosPrestadosStr.append(item.toString()).append("\n");
        }

        return "Usuario{"
                + "nombreCompleto='" + nombreCompleto + '\''
                + ", DNI='" + DNI + '\''
                + ", numSocio=" + numSocio
                + ", tlf=" + tlf
                + ", estaSancionado=" + (estaSancionado ? "Sí" : "No")
                + "\n" + librosPrestadosStr.toString()
                + '}';
    }

}
