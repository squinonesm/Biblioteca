package ies_comercio.biblioteca;

import clases.biblio.Biblioteca;
import clases.biblio.Item;
import clases.biblio.Libro;
import clases.biblio.Revista;
import clases.biblio.Usuario;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.GregorianCalendar;

/**
 *
 * @author Sergio Quiñones Majuelo
 * @date 14-02-2024
 * @version 0.1
 *
 */
public class Run {

    public static void main(String[] args) {

        Map<String, Item> fondo = new HashMap<>();

        Faker f = new Faker();

        Biblioteca b1 = new Biblioteca(10, "Biblioteca Central", "Calle Principal 123", 0, 100, fondo);

        // Crear una lista para almacenar los items
        ArrayList<Item> items = new ArrayList<>();

        // Crear 50 items con Faker (incluyendo libros y revistas)
        for (int i = 0; i < 50; i++) {
            if (f.random().nextBoolean()) { // Generar aleatoriamente un libro o una revista
                // Crear un libro
                Libro libro = new Libro(
                        f.book().author(),
                        f.code().isbn10(),
                        f.book().title(),
                        (short) f.number().numberBetween(50, 1000),
                        f.book().publisher(),
                        new GregorianCalendar(f.random().nextInt(1900, 2023), f.random().nextInt(0, 11), f.random().nextInt(1, 28)), // Fecha aleatoria entre 1900 y 2023
                        false, // Inicialmente no está prestado
                        f.book().genre()
                );
                items.add(libro);
            } else {
                // Crear una revista
                Revista revista = new Revista(
                        f.code().isbn10(),
                        f.lorem().word(),
                        f.book().title(),
                        (short) f.number().numberBetween(10, 100),
                        f.book().publisher(),
                        new GregorianCalendar(f.random().nextInt(1900, 2023), f.random().nextInt(0, 11), f.random().nextInt(1, 28)), // Fecha aleatoria entre 1900 y 2023
                        false, // Inicialmente no está prestado
                        f.book().genre()
                );
                items.add(revista);
            }
        }

        for (Item item : items) {
            // Generar un código único para cada item (usando el título, por ejemplo)
            String titulo = item.getTitulo();
            // Agregar el item a la biblioteca usando el título como clave
            b1.altaItem(titulo, item);
        }

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        // Crear 5 usuarios con Faker
        for (int i = 0; i < 5; i++) {
            Usuario usuario = new Usuario(
                    f.name().fullName(), // Nombre completo
                    f.idNumber().valid(), // DNI
                    f.number().numberBetween(1000, 9999), // Número de socio
                    f.number().numberBetween(600000000, 999999999), // Número de teléfono
                    new ArrayList<>(), // Lista de libros prestados inicialmente vacía
                    false // Inicialmente no está sancionado      
            );
            listaUsuarios.add(usuario);
        }

        System.out.println("Usuarios creados:");
        for (Usuario usuario : listaUsuarios) {
            System.out.println(usuario);
        }
        System.out.println();

        System.out.println(listaUsuarios.get(0).tomarItemPrestado(items.get(0)));
        System.out.println(listaUsuarios.get(0).tomarItemPrestado(items.get(0)));
        System.out.println(listaUsuarios.get(0).tomarItemPrestado(items.get(1)));
        System.out.println(listaUsuarios.get(0).tomarItemPrestado(items.get(2)));
        System.out.println(listaUsuarios.get(0).tomarItemPrestado(items.get(3)));
        System.out.println(listaUsuarios.get(0).tomarItemPrestado(items.get(4)));
        System.out.println(listaUsuarios.get(0).tomarItemPrestado(items.get(5)));

        System.out.println(listaUsuarios.get(0).devolverItem(items.get(0)));

        System.out.println(b1.listadoDeLibros());
        System.out.println(b1.listadoDeRevistas());
        System.out.println(b1.listadoFondo());
        System.out.println(b1.listadoPorTema("Biography/Autobiography"));

    }
}
