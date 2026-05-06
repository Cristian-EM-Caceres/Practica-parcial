// Archivo: AppProgramacionFuncional.java

public class App {

    public static void main(String[] args) {

        
        // creacion de hilos
        

        System.out.println("=== Ejercicio 1.1: Thread ===");

        //objetos de la clase que extiende Thread
        TareaHilo h1 = new TareaHilo("Hilo 1");
        TareaHilo h2 = new TareaHilo("Hilo 2");

        
        h1.start();
        h2.start();

        System.out.println("=== Ejercicio 1.2: Runnable ===");

        //  instancia de Runnable
        TareaRunnable tarea = new TareaRunnable();

        Thread t1 = new Thread(tarea, "Runnable 1");
        Thread t2 = new Thread(tarea, "Runnable 2");

        t1.start();
        t2.start();


        
        // condicion de carrera
        

        System.out.println("=== Ejercicio 2.1: Condición de carrera ===");

        Contador contador = new Contador();

        Thread c1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                contador.incrementar();
            }
        });

        Thread c2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                contador.incrementar();
            }
        });

        c1.start();
        c2.start();

        try {
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Resultado incorrecto por condicion de carrera
        System.out.println("Valor final sin sincronizar: " + contador.valor);


       //sincronizacion

        System.out.println("=== Ejercicio 3.1: synchronized ===");

        ContadorSync contadorSync = new ContadorSync();

        Thread s1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                contadorSync.incrementar();
            }
        });

        Thread s2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                contadorSync.incrementar();
            }
        });

        s1.start();
        s2.start();

        try {
            s1.join();
            s2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ahora el resultado es correcto
        System.out.println("Valor final sincronizado: " + contadorSync.valor);


       //control de hilos

        System.out.println("=== Ejercicio 4.1: Prioridades ===");

        Thread p1 = new Thread(new TareaIdentidad(), "Baja prioridad");
        Thread p2 = new Thread(new TareaIdentidad(), "Alta prioridad");

        // Asignacion de prioridades
        p1.setPriority(Thread.MIN_PRIORITY);
        p2.setPriority(Thread.MAX_PRIORITY);

        p1.start();
        p2.start();


        System.out.println("=== Ejercicio 4.2: join e interrupt ===");

        Thread largo = new Thread(() -> {
            try {
                System.out.println("Tarea larga iniciada...");
                Thread.sleep(5000); // Simula trabajo largo
                System.out.println("Tarea larga terminada");
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido!");
            }
        });

        largo.start();

        try {
            // Espera a que termine el hilo
            largo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main continúa después de join");

        // interrupcion
        Thread interrumpible = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("No fue interrumpido");
            } catch (InterruptedException e) {
                System.out.println("Interrupción detectada!");
            }
        });

        interrumpible.start();

        // Interrupcion antes de que termine
        interrumpible.interrupt();
    }
}


//Extends Thread
class TareaHilo extends Thread {

    String nombre;

    // Constructor
    public TareaHilo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(nombre + " -> " + i);
        }
    }
}


//Runable
class TareaRunnable implements Runnable {

    @Override
    public void run() {
        // Se ejecuta cuando el hilo arranca
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " -> " + i);
        }
    }
}


//contador sin sincronizar
class Contador {
    int valor = 0;

    // Método que incrementa sin protección
    public void incrementar() {
        valor++;
    }
}


//contador con sincronizacion
class ContadorSync {
    int valor = 0;

    // synchronized evita acceso simultaneo
    public synchronized void incrementar() {
        valor++;
    }
}


//indentidad de hilo
class TareaIdentidad implements Runnable {

    @Override
    public void run() {
        // Obtiene el hilo actual
        Thread t = Thread.currentThread();

        // Imprime nombre y prioridad
        System.out.println("Ejecutando: " + t.getName() +
                " | Prioridad: " + t.getPriority());
    }
}