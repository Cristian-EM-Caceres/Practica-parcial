import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.Optional;

public class AppProgramacionFuncional {

    public static void main(String[] args) {


        System.out.println("=== SECCION 1 ===");

        // Ejercicio 1.1
        System.out.println("-- Ejercicio 1.1 --");

        // Predicate evalua una condicion y devuelve true/false
        Predicate<Integer> esPar = n -> n % 2 == 0; // Devuelve true si el número es par
        System.out.println("4 es par? " + esPar.test(4)); // Ejecuta el Predicate

        
        Function<String, Integer> longitud = s -> s.length(); // Devuelve longitud del texto
        System.out.println("Longitud de 'Hola': " + longitud.apply("Hola")); // Ejecuta la función

        // consumer: recibe un valor y no devuelve nada
        Consumer<Integer> imprimir = n -> System.out.println("Numero: " + n); // Imprime el número
        imprimir.accept(10); // Ejecuta el Consumer

        // Supplier no recibe nada y devuelve un valor
        Supplier<Double> random = () -> Math.random(); // Genera número aleatorio
        System.out.println("Numero aleatorio: " + random.get()); // Ejecuta el Supplier


        
        System.out.println("\n-- Ejercicio 1.2 --");

        // crea una lista de textos
        List<String> textos = new ArrayList<>(Arrays.asList("Java", "Programacion", "Funcional", "Hola"));

        // ordena la lista segun la longitud de cada palabra
        textos.sort((a, b) -> a.length() - b.length());

        System.out.println("Ordenados por longitud: " + textos); // Muestra resultado


        
        System.out.println("\n-- Ejercicio 1.3 --");

        IntPredicate esParInt = n -> n % 2 == 0;
        System.out.println("6 es par? " + esParInt.test(6));

        
        ToIntFunction<String> longitudInt = s -> s.length();
        System.out.println("Longitud de 'Mundo': " + longitudInt.applyAsInt("Mundo"));


        System.out.println("\n=== SECCION 2 ===");

        
        System.out.println("-- Ejercicio 2.1 --");

        // crea un stream y aplica operaciones
        long count = Stream.of(2, 5, 3, 3, 6, 2, 4)
                .distinct() // Elimina duplicados
                .skip(1)
                .limit(3)
                .count();   // Cuenta elementos finales

        System.out.println("Cantidad de elementos: " + count);


        
        System.out.println("\n-- Ejercicio 2.2 --");

        long resultado = Stream.of(1, 2, 3, 4, 5, 6)
                .filter(n -> n > 3) // Filtra numeros mayores a 3
                .peek(n -> System.out.println("Filtrado: " + n)) // Muestra cada elemento mientras pasa
                .count(); // Ejecuta el stream

        System.out.println("Total: " + resultado);


       

        System.out.println("\n=== SECCION 3 ===");

        // Ejercicio 3.1
        System.out.println("-- Ejercicio 3.1 --");

        // Convierte nombres a mayúsculas
        Stream.of("Juan", "Maria", "Ana")
                .map(s -> s.toUpperCase()) // Transforma cada elemento
                .forEach(System.out::println); // Imprime cada uno


        // Ejercicio 3.2
        System.out.println("\n-- Ejercicio 3.2 --");

        // Convierte Strings a su longitud y suma
        int suma = Stream.of("Juan", "Maria", "Ana")
                .mapToInt(s -> s.length()) // Convierte a IntStream
                .sum(); // Suma todos los valores

        System.out.println("Suma de letras: " + suma);


        // Ejercicio 3.3
        System.out.println("\n-- Ejercicio 3.3 --");

        // Lista de listas
        List<List<String>> lista = Arrays.asList(
                Arrays.asList("Juan", "Pedro"),
                Arrays.asList("Maria", "Ana", "Luis")
        );

        long total = lista.stream()
                .flatMap(l -> l.stream()) // Aplana las listas en un solo stream
                .filter(s -> s.length() > 4) // Filtra nombres largos
                .count(); // Cuenta resultados

        System.out.println("Nombres con mas de 4 letras: " + total);


        // Ejercicio 3.4
        System.out.println("\n-- Ejercicio 3.4 --");

        List<String> palabras = Arrays.asList("Java", "Python", "C", "JavaScript");

        System.out.println("Orden natural:");
        palabras.stream()
                .sorted() // Orden alfabético
                .forEach(System.out::println);

        System.out.println("Orden por longitud:");
        palabras.stream()
                .sorted((a, b) -> a.length() - b.length()) // Orden por tamaño
                .forEach(System.out::println);


    

        System.out.println("\n=== SECCION 4 ===");

        // Ejercicio 4.1
        System.out.println("-- Ejercicio 4.1 --");

        // anyMatch: si alguno cumple la condición
        System.out.println("anyMatch > 5: " + Stream.of(2, 5, 7, 3, 6, 2, 3).anyMatch(n -> n > 5));

        
        System.out.println("allMatch > 0: " + Stream.of(2, 5, 7).allMatch(n -> n > 0));

        // noneMatch: si ninguno cumple
        System.out.println("noneMatch < 0: " + Stream.of(2, 5, 7).noneMatch(n -> n < 0));


        // Ejercicio 4.2
        System.out.println("\n-- Ejercicio 4.2 --");

        Optional<Integer> primeroPar = Stream.of(1, 3, 5, 6, 7)
                .filter(n -> n % 2 == 0) // Busca pares
                .findFirst(); // Devuelve el primero encontrado

        // Verifica si existe valor
        if (primeroPar.isPresent()) {
            System.out.println("Primer par: " + primeroPar.get()); // Obtiene el valor
        }


        // Ejercicio 4.3
        System.out.println("\n-- Ejercicio 4.3 --");

        Optional<Integer> sumaReduce = Stream.of(1, 2, 3, 4)
                .reduce((a, b) -> a + b); // Suma todos los valores

        System.out.println("Suma total: " + sumaReduce.get());


        // Ejercicio 4.4
        System.out.println("\n-- Ejercicio 4.4 --");

        // lista con duplicados
        List<Integer> numeros = Arrays.asList(1, 2, 2, 3, 4, 4);

        // Elimina duplicados
        List<Integer> sinDuplicados = numeros.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Lista sin duplicados: " + sinDuplicados);


        
        List<Persona> personas = Arrays.asList(
                new Persona(1, "Juan"),
                new Persona(2, "Maria"),
                new Persona(3, "Pedro")
        );

        // Conviercion de lista a mapa
        Map<Integer, String> mapa = personas.stream()
                .collect(Collectors.toMap(p -> p.getDni(), p -> p.getNombre()));

        System.out.println("Mapa: " + mapa);
    }
}

class Persona {
    private int dni; // Atributo DNI
    private String nombre; // Atributo nombre

    public Persona(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }
}