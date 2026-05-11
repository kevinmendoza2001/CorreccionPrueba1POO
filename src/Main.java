import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=========== SISTEMA DE DRONES ===========");
        System.out.println("Seleccione tipo de dron:");
        System.out.println("1. Dron Liviano");
        System.out.println("2. Dron Carga");
        System.out.println("3. Dron Emergencia");
        System.out.print("Opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        Dron dron = null;

        switch (opcion) {
            case 1:
                dron = new DronLiviano();
                break;
            case 2:
                dron = new DronCarga();
                break;
            case 3:
                dron = new DronEmergencia();
                break;
            default:
                System.out.println("ERROR: Opción inválida.");
                sc.close();
                return;
        }

        // MOSTRAR INFORMACIÓN INICIAL (DATOS QUEMADOS)
        System.out.println("\n===== INFORMACIÓN INICIAL (VALORES QUEMADOS) =====");
        dron.mostrarInformacion();

        // INGRESO DE DATOS
        System.out.println("\n===== INGRESO DE DATOS POR TECLADO =====");

        System.out.print("Ingrese codigo: ");
        String codigo = sc.nextLine();

        System.out.print("Ingrese modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Ingrese distancia (km): ");
        double distancia = sc.nextDouble();

        System.out.print("Ingrese peso (kg): ");
        double peso = sc.nextDouble();

        System.out.print("Ingrese horas de vuelo: ");
        double horas = sc.nextDouble();

        // Actualización usando setters
        dron.setCodigo(codigo);
        dron.setModelo(modelo);
        dron.setDistanciaKm(distancia);
        dron.setPesoPaquete(peso);
        dron.setHorasVuelo(horas);

        // VALIDACIÓN
        System.out.println("\nValidando datos...");
        if (dron.validarDatos()) {
            System.out.println("Datos correctos");
            System.out.println("Calculando costo...");

            // MOSTRAR INFORMACIÓN ACTUALIZADA
            System.out.println("\n===== INFORMACIÓN ACTUALIZADA =====");
            dron.mostrarInformacion();

            // CAMBIO CON SETTER
            System.out.println("\n-- Cambio de peso con setter --");

            double costoInicial = dron.calcularCostoEntrega();
            System.out.println("Costo inicial -> $ " + costoInicial);

            System.out.print("Ingrese nuevo peso para recalcular: ");
            double nuevoPeso = sc.nextDouble();

            dron.setPesoPaquete(nuevoPeso);

            if (dron.validarDatos()) {
                double nuevoCosto = dron.calcularCostoEntrega();
                System.out.println("Nuevo costo -> $ " + nuevoCosto);
            } else {
                System.out.println("ERROR: No se pudo recalcular porque el nuevo peso es inválido.");
            }

        } else {
            System.out.println("Datos incorrectos. No se puede operar.");
        }

        System.out.println("\n====== FIN DEL PROGRAMA ======");
        sc.close();
    }
}