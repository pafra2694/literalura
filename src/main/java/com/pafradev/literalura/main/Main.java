package com.pafradev.literalura.main;

import com.pafradev.literalura.dto.Authors;
import com.pafradev.literalura.dto.BooksData;
import com.pafradev.literalura.models.Autor;
import com.pafradev.literalura.models.Libro;
import com.pafradev.literalura.repository.AutorRepository;
import com.pafradev.literalura.repository.LibroRepository;
import com.pafradev.literalura.services.ConsumoAPI;
import com.pafradev.literalura.services.ConvertData;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

private String opcion = "";
private Scanner sc = new Scanner(System.in);
private ConsumoAPI consumoAPI = new ConsumoAPI();
private ConvertData conversor = new ConvertData();
private LibroRepository repositorio;
private AutorRepository repositorioAutor;
private List<Libro> libros;
private List<Autor> autores;

public Main (LibroRepository repository, AutorRepository repositoryAutor) {this.repositorio = repository; this.repositorioAutor = repositoryAutor;}

    public void muestraMenu(){
        while (!opcion.equals("0")){
            var menu = """
                    ***************BIENVENIDO A LITERALURA**************
                    Selecciona una opción del menú:
                    1. Buscar libro por título
                    2. Listar libros registrados
                    3. Listar autores registrados
                    4. Listar autores vivos en un determinado año
                    5. Listar libros por idioma
                    
                    0. Salir
                    """;
            System.out.println(menu);
            System.out.print("Opcion: ");
            opcion = sc.nextLine();

            if(opcion.matches("^[1-5]$")){
                switch (opcion){
                    case "1":
                        buscarLibroPorTitulo();
                        break;
                    case "2":
                        mostrarLibrosBuscados();
                        break;
                    case "3":
                        mostrarAutoresRegistrados();
                        break;
                    case "4":
                        mostrarAutoresVivosAnio();
                        break;
                    case "5":
                        mostrarLibrosPorIdioma();
                        break;
                    default:
                        break;
                }
            } else if (opcion.equals("0")) {
                System.out.println("Hasta luego!");
            } else {
                System.out.println("Opción Incorrecta. Ingrese una opción válida dentro del menu.");
            }
        }
        sc.close();
    }

    private void buscarLibroPorTitulo() {
        System.out.print("Escribe el nombre del libro que deseas buscar:");
        var nombreLibro = sc.nextLine();
        var json = consumoAPI.obtenerDatos("https://gutendex.com/books/?search="+nombreLibro.replace(" ","+"));
        try{
            var libros = conversor.obtenerDatos(json, BooksData.class);
            System.out.println(libros.resultados().get(0));
            Autor autor = repositorioAutor.findByNombre(libros.resultados().get(0).autores().get(0).nombre())
                    .orElseGet(() -> {
                        Autor nuevoAutor = new Autor(libros.resultados().get(0).autores().get(0));
                        return repositorioAutor.save(nuevoAutor);
                    });
//            Autor autor = new Autor(libros.resultados().get(0).autores().get(0));
//            repositorioAutor.save(autor);

            Libro libro = new Libro(libros.resultados().get(0),autor);
            try {
                repositorio.save(libro);
            }catch (DataIntegrityViolationException e){
                System.out.println("El libro ya se encuentra en la base de datos");
            }
        }catch (Exception e){
            System.out.println("Libro no encontrado");
        }
    }


    private void mostrarLibrosBuscados() {
        libros = repositorio.findAll();
        libros.stream()
                .sorted(Comparator.comparing(Libro::getTitulo))
                .forEach(System.out::println);
    }


    private void mostrarAutoresRegistrados() {
        autores = repositorioAutor.findAll();
        autores.stream()
                .sorted(Comparator.comparing(Autor::getNombre))
                .forEach(System.out::println);
    }


    private void mostrarAutoresVivosAnio() {
        System.out.print("Ingrese el año:");
        var ano = sc.nextLine();
        try{
            Integer anio = Integer.parseInt(ano);
            autores = repositorioAutor.obtenerAutoresVivosAnio(anio);
            List<Autor> autoresEncontrados = autores.stream()
                    .sorted(Comparator.comparing(Autor::getNombre))
                    .collect(Collectors.toList());
            if(autoresEncontrados.size()>1){
                autoresEncontrados.forEach(System.out::println);
            }else{
                System.out.println("No se encontraron autores vivos en el año especificado");
            }
        }catch (NumberFormatException e){
            System.out.println("Ingrese un año válido, intente nuevamente.");
        }
    }

    private void mostrarLibrosPorIdioma() {
        System.out.print("""
                Seleccione el idioma que desee buscar:
                1. Español
                2. Inglés
                3. Francés
                4. Portugués
                
                Opcion: """);
        String opcionIdioma = sc.nextLine();
        switch (opcionIdioma){
            case "1":
                libros = repositorio.obtenerLibrosPorIdioma("es");
                mostrarLibrosOrdenadosPorTitulo(libros);
                break;
            case "2":
                libros = repositorio.obtenerLibrosPorIdioma("en");
                mostrarLibrosOrdenadosPorTitulo(libros);
                break;
            case "3":
                libros = repositorio.obtenerLibrosPorIdioma("fr");
                mostrarLibrosOrdenadosPorTitulo(libros);
                break;
            case "4":
                libros = repositorio.obtenerLibrosPorIdioma("pt");
                mostrarLibrosOrdenadosPorTitulo(libros);
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
        }
    }

    public void mostrarLibrosOrdenadosPorTitulo(List<Libro> libros){
        libros.stream()
                .sorted(Comparator.comparing(Libro::getTitulo))
                .forEach(System.out::println);
    }


}
