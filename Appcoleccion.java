import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.Collections;

public class Appcoleccion {
        public static void main(String[] args) throws Exception {
                int[] numero = new int[5];
                numero[0] = 10;
                numero[1] = 20;
                numero[2] = 30;
                numero[3] = 40;
                numero[4] = 50;
                // esta parte actualiza el segundo numero
                numero[2] = 100;

                // recuperacion del valor original del numero modificado
                System.out.println(numero[2]);
                System.out.println(numero.length);

                System.out.println(
                                "===========================================================================================================================");
                // arreglo original
                System.out.println("=====Arreglo original=====");
                String[] nombres = {
                                "Daniel", "Ezequiel", "Esteban", "Cristian", "Abigail"

                };
                // arreglo ordenado
                System.out.println(Arrays.toString(nombres));
                Arrays.sort(nombres);
                System.out.println("=====arreglo ordenado=====");
                System.out.println(Arrays.toString(nombres));
                String NombreBuscado = "Abigail";
                int posicion = Arrays.binarySearch(nombres, NombreBuscado);

                System.out.println(
                                "===========================================================================================================================");
                // Crud con Arraylist
                ArrayList<String> lista = new ArrayList<>();
                // lista original
                lista.add("Cristian");
                lista.add("Esteban");
                lista.add("Ezequiel");
                System.out.println("lista original" + lista);

                // modificacion del segundo nombre
                lista.set(1, "se modifico el segundo nombre");
                // obtener el primer nombre
                String primero = lista.get(0);
                System.out.println("Primer nombre:" + primero);

                // eliminar el ultimo nombre

                lista.remove(lista.size() - 3);

                System.out.println("lista final" + lista);

                System.out.println(
                                "===========================================================================================================================");

                System.out.println("Listas Inmutables vs LinkedList");

                List<String> listaInmutable = List.of("A", "B", "C", "D");

                // Crear LinkedList mutable
                LinkedList<String> listaMutable = new LinkedList<>(listaInmutable);

                System.out.println("Lista mutable inicial: " + listaMutable);

                // Insertar en el medio
                listaMutable.add(2, "X"); // Inserta en posición 2

                System.out.println("Después de insertar en el medio: " + listaMutable);

                // Otra insercion
                listaMutable.add(1, "Y");

                System.out.println("Lista final: " + listaMutable);

                System.out.println(
                                "===========================================================================================================================");
                System.out.println("Unicidad en Sets");

                HashSet<Integer> conjunto = new HashSet<>();

                // agregar el mismo numero tres veces
                conjunto.add(10);
                conjunto.add(10);
                conjunto.add(10);

                // Verificar tamaño
                System.out.println("Tamaño del conjunto: " + conjunto.size());

                // mostrar contenido
                System.out.println("Contenido del conjunto: " + conjunto);

                // Verificar si existe un numero
                if (conjunto.contains(10)) {
                        System.out.println("El número 10 existe en el conjunto");
                }

                // Eliminar el numero
                conjunto.remove(10);

                // verificacion final
                System.out.println("Después de eliminar 10: " + conjunto);
                System.out.println("Tamaño final: " + conjunto.size());

                System.out.println(
                                "===========================================================================================================================");

                System.out.println("Colas de doble extremo con ArrayDeque");

                ArrayDeque<String> deque = new ArrayDeque<>();

                // Agregar elementos al inicio y al final
                deque.addFirst("B");
                deque.addFirst("A");
                deque.addLast("C");
                deque.addLast("D");

                System.out.println("Deque inicial: " + deque);

                // eliminar desde los extremos
                String primeroo = deque.removeFirst(); // saca A
                String ultimo = deque.removeLast(); // saca D

                System.out.println("Elemento removido al inicio: " + primeroo);
                System.out.println("Elemento removido al final: " + ultimo);

                // estado final
                System.out.println("Deque final: " + deque);

                System.out.println(
                                "===========================================================================================================================");

                System.out.println("Manejo de HashMap");

                HashMap<Integer, String> usuarioos = new HashMap<>();

                // entradas
                usuarioos.put(1, "Juan");
                usuarioos.put(2, "Esteban");
                usuarioos.put(3, "Pedro");

                System.out.println("Mapa inicial: " + usuarioos);

                // obtener un nombre por ID
                String nombre = usuarioos.get(2);
                System.out.println("Usuario con ID 2: " + nombre);

                // reemplazar un valor existente
                usuarioos.replace(2, "Mariana");
                System.out.println("Después de actualizar ID 2: " + usuarioos);

                // eliminar un registro
                usuarioos.remove(3);
                System.out.println("Después de eliminar ID 3: " + usuarioos);

                System.out.println(
                                "===========================================================================================================================");

                System.out.println("Ordenamiento con TreeMap");
                TreeMap<Integer, String> usuarios = new TreeMap<>();

                // insertar datos desordenados
                usuarioos.put(5, "Lucas");
                usuarioos.put(2, "Maria");
                usuarioos.put(8, "Sofia");
                usuarioos.put(1, "Juan");

                // mostrar mapa ordenado
                System.out.println("TreeMap ordenado: " + usuarioos);

                // recorrer claves
                System.out.println("\nRecorrido de claves:");
                for (Integer clave : usuarioos.keySet()) {
                        System.out.println("Clave: " + clave + " -> Valor: " + usuarioos.get(clave));
                }
                System.out.println(
                                "===========================================================================================================================");
        }

}
