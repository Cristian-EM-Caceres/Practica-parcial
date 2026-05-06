import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class GestionExcepciones {

    public static void main(String[] args) {
        System.out.println("--- SECCION 1: CONCEPTOS BASICOS ---");
        ejercicio1_1();
        ejercicio1_2();
        ejercicio1_3("abc"); // Prueba con error de formato
        ejercicio1_3("0"); // Prueba con error de división

        System.out.println("\n--- SECCION 2: METODOLOGIAS FAIL-FAST ---");
        ejercicio2_1_y_2_2();

        System.out.println("\n--- SECCION 3: EXCEPCIONES PERSONALIZADAS ---");
        ejercicio3_1();
        ejercicio3_2();

        System.out.println("\n--- SECCION 4: AUTOMATIZACION DE RECURSOS ---");
        ejercicio4_1();
    }



    public static void ejercicio1_1() {
        System.out.println("\nEj 1.1: Captura de informacion");
        try {
            int numero = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Mensaje de error: " + e.getMessage());
            System.out.println("Tipo de excepcion: " + e.getClass().getName());
        }
    }

    public static void ejercicio1_2() {
        System.out.println("\nEj 1.2: Bloque finally");
        try {
            int resultado = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Atrapado: Division por cero.");
        } finally {
            System.out.println("Limpieza final .");
        }
    }

    public static void ejercicio1_3(String entrada) {
        System.out.println("\nEj 1.3: Multi-catch con entrada: " + entrada);
        try {
            int numero = Integer.parseInt(entrada);
            int division = 100 / numero;
            System.out.println("Resultado: " + division);
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println("Error de calculo o conversion.");
        }
    }

    

    public static void registrarUsuario(String nombre, int edad) {
        
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }
        if (edad < 0) {
            // Ej 2.2: Mensaje
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }
        System.out.println("Usuario " + nombre + " registrado con exito.");
    }

    public static void ejercicio2_1_y_2_2() {
        System.out.println("\nEj 2.1 y 2.2: Fail-fast y mensajes claros");
        try {
            registrarUsuario("Gaby", -5);
        } catch (IllegalArgumentException e) {
    
            System.out.println("Captura especifica: " + e.getMessage());
        }
    }

    // 3.1: Excepción Checked
    static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String mensaje) {
            super(mensaje);
        }
    }

    static class CuentaBancaria {
        private double saldo = 100.0;

        public void retirar(double monto) throws SaldoInsuficienteException {
            if (monto > saldo) {
                throw new SaldoInsuficienteException("Error: Saldo insuficiente. Saldo actual: " + saldo);
            }
            saldo -= monto;
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
        }
    }

    public static void ejercicio3_1() {
        System.out.println("\nEj 3.1: Excepcion Checked Personalizada");
        CuentaBancaria cuenta = new CuentaBancaria();
        try {
            cuenta.retirar(200.0);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }

    // 3.2: Excepción Unchecked
    static class ProductoInvalidoException extends RuntimeException {
        public ProductoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    static class Producto {
        public Producto(double precio) {
            if (precio <= 0) {
                throw new ProductoInvalidoException("El precio debe ser mayor a cero.");
            }
        }
    }

    public static void ejercicio3_2() {
        System.out.println("\nEj 3.2: Excepcion Unchecked Personalizada");
        System.out.println("Instanciando producto con precio -10...");

        try {
            Producto p = new Producto(-10);
        } catch (ProductoInvalidoException e) {
            System.out.println("Capturada runtime: " + e.getMessage());
        }
    }

    public static void ejercicio4_1() {
        System.out.println("\nEj 4.1: Try-with-resources");
        String nombreArchivo = "personas.txt";

        // Preparar el archivo para la prueba
        try (FileWriter fw = new FileWriter(nombreArchivo)) {
            fw.write("Juan Perez\nMaria Garcia\nCarlos Lopez");
        } catch (IOException e) {
            System.out.println("Error creando archivo de prueba.");
        }

        // Lectura usando try-with-resources
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("Contenido del archivo:");
            while ((linea = br.readLine()) != null) {
                System.out.println("- " + linea);
            }
        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}
