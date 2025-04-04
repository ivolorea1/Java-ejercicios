import java.util.Scanner;
import java.util.ArrayList;


public class Biblioteca {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Libro> libros = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    //clase libro
    public static class Libro {
        int id;
        String titulo;
        String autor;

        // constructor
        public Libro(int id, String titulo, String autor) {
            this.id = id;
            this.titulo = titulo;
            this.autor = autor;
        }
        @Override
        public String toString() {
            return "ID: " + id + ", Título: " + titulo + ", Autor: " + autor;
        }
    }

    //clase usuario
    public static class Usuario {
        int dni;
        String nombre;
        ArrayList<Libro> librosPrestados;

        // constructor
        public Usuario(int dni, String nombre) {
            this.dni = dni;
            this.nombre = nombre;
            this.librosPrestados = new ArrayList<>();
        }
        @Override
        public String toString() {
            return "DNI: " + dni + ", Nombre: " + nombre + ", libros adquiridos: " + librosPrestados;
        }
    }

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1: Opciones de Usuario");
            System.out.println("2: Opciones de Biblioteca");
            System.out.println("3: Salir");

            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    menuUsuario();
                    break;
                case 2:
                    menuBiblioteca();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 3);

        sc.close();
    }

    // === SUBMENÚ USUARIO ===

    public static void menuUsuario() {
        int opcion;

        do {
            System.out.println("\n--- Menú Usuario ---");
            System.out.println("1: Agregar usuario");
            System.out.println("2: Prestar libro");
            System.out.println("3: Mostrar usuarios y libros prestados");
            System.out.println("4: Volver al menú principal");

            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarUsuario();
                    break;
                case 2:
                    prestarLibro();
                    break;
                case 3:
                    mostrarUsuarios();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 4);
    }

    public static void menuBiblioteca() {
        int opcion;

        do {
            System.out.println("\n--- Menú Biblioteca ---");
            System.out.println("1: Mostrar libros");
            System.out.println("2: Agregar libro");
            System.out.println("3: Buscar libro");
            System.out.println("4: Eliminar libro");
            System.out.println("5: Volver al menú principal");

            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    mostrarLibros();
                    break;
                case 2:
                    agregarLibro();
                    break;
                case 3:
                    buscarLibro();
                    break;
                case 4:
                    eliminarLibro();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 5);
    }


    public static void agregarLibro() {

        System.out.print("Ingrese el ID del libro: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese el titulo del libro: ");
        String titulo = sc.nextLine();

        System.out.print("Ingrese el autor del libro: ");
        String autor = sc.nextLine();

        libros.add(new Libro(id, titulo, autor));

        System.out.println("Libro agregado: " + libros);
    }

    public static void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("\nLista de usuarios:");
            for (Usuario u : usuarios) {
                System.out.println(u);
            }
        }
    }


    public static void mostrarLibros() {

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            System.out.println("\n Lista de libros:");
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }


    public static void buscarLibro() {

        System.out.print("Ingrese el ID del libro a buscar: ");
        int idBuscar = sc.nextInt();
        sc.nextLine();

        for (Libro libro : libros) {
            if (libro.id == idBuscar) {
                System.out.println("Libro encontrado: " + libro);
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }


    public static void eliminarLibro() {

        System.out.print("Ingrese el ID del libro a eliminar: ");

        int idEliminar = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).id == idEliminar) {
                libros.remove(i);
                System.out.println("Libro eliminado.");
                return;
            }
        }
        System.out.println("No se encontró el libro con ese ID.");
    }

    public static void agregarUsuario() {

        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el DNI del usuario: ");
        int dni = sc.nextInt();
        sc.nextLine();

        usuarios.add(new Usuario(dni, nombre));

        System.out.println("Usuario agregado: " + usuarios);
    }

    public static void prestarLibro(){

        System.out.println("ingrese usuario que quiere pasar a un libro: ");
        String usuario1 = sc.nextLine();
        String tituloEncontrar ;
        Usuario usuarioEncontrado = null;



        for (Usuario usuario : usuarios) {

            if (usuario.nombre.equals(usuario1)){

                usuarioEncontrado = usuario;
                break;
            }else{
                System.out.println("usuario no encontrado");
                return;
            }
        }

        System.out.println("libro que desea prestar: ");
        tituloEncontrar = sc.nextLine();
        Libro libroEncontrado = null;

        for (Libro libro : libros) {

            if (libro.titulo.equals(tituloEncontrar)){

                libroEncontrado = libro;
                System.out.println("Usuario encontrado: " + libro);

                break;
            }else{
                System.out.println("usuario no encontrado");
            }
        }


        usuarioEncontrado.librosPrestados.add(libroEncontrado);
        libros.remove(libroEncontrado); // Lo eliminamos de la lista general

        System.out.println("✅ Libro prestado con éxito a " + usuarioEncontrado.nombre);
    }
}