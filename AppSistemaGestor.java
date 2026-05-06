public class AppSistemaGestor {

    public static void main(String[] args) {

        // ====== PRUEBA CUENTA BANCARIA ======
        CuentaBancaria c1 = new CuentaBancaria(777, 120);
        c1.depositar(50);

        // ====== PRUEBA USUARIO ======
        Usuario user1 = new Usuario();
        user1.setNombre("Carlitoo");
        System.out.println("Nombre: " + user1.getNombre());

        Usuario u1 = new Usuario("Cristian", 21);
        System.out.println("Nombre: " + u1.getNombre() + " Edad: " + u1.getEdad());

        u1.ActualizarUsuario("caceres@gmail.com", 2657);
        System.out.println("Correo: " + u1.getCorreo() + " Telefono: " + u1.getTelefono());

        // ====== SISTEMA GESTOR ======
        SistemaGestor.mostrarMaxConexiones();

        // ====== REPORTE ======
        Reporte rep = new Reporte();
        rep.generarReporteUsuario(u1);
        rep.generarReporteCuenta(c1);
    }
}

// ================= CUENTA BANCARIA =================
class CuentaBancaria {
    private int numeroCuenta;
    private double saldo;

    public CuentaBancaria(int numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Monto ingresado correctamente. Saldo actual: " + saldo);
        } else {
            System.out.println("ERROR: el monto no puede ser negativo");
        }
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }
}

// ================= USUARIO =================
class Usuario {
    private String nombre;
    private int edad;
    private String correo;
    private int telefono;

    public Usuario() {}

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void ActualizarUsuario(String correo, int telefono) {
        this.correo = correo;
        this.telefono = telefono;
    }

    // getters y setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setTelefono(int telefono) { this.telefono = telefono; }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCorreo() { return correo; }
    public int getTelefono() { return telefono; }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " Edad: " + edad;
    }
}

// ================= SISTEMA GESTOR =================
class SistemaGestor {
    public static final int MAX_CONEXIONES = 10;

    public static void mostrarMaxConexiones() {
        System.out.println("Maximo de conexiones: " + MAX_CONEXIONES);
    }
}

// ================= REPORTE (COMPLETADO) =================
class Reporte {

    public void generarReporteUsuario(Usuario u) {
        System.out.println("\n--- REPORTE DE USUARIO ---");
        System.out.println("Nombre: " + u.getNombre());
        System.out.println("Edad: " + u.getEdad());
        System.out.println("Correo: " + u.getCorreo());
        System.out.println("Telefono: " + u.getTelefono());
    }

    public void generarReporteCuenta(CuentaBancaria c) {
        System.out.println("\n--- REPORTE DE CUENTA ---");
        System.out.println("Numero de cuenta: " + c.getNumeroCuenta());
        System.out.println("Saldo actual: " + c.getSaldo());
    }
}
