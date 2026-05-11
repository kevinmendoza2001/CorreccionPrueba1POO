public class DronEmergencia extends Dron {

    private double recargoUrgencia;
    private int nivelPrioridad;

    // Constructor sin parámetros
    public DronEmergencia() {
        setCodigo("DE-000");
        setModelo("Emergente");
        setDistanciaKm(5);
        setPesoPaquete(2);
        setHorasVuelo(1);
        setCostoBase(8.00);

        this.recargoUrgencia = 10.00;
        this.nivelPrioridad = 2;
    }

    public double getRecargoUrgencia() {
        return recargoUrgencia;
    }

    public void setRecargoUrgencia(double recargoUrgencia) {
        if (recargoUrgencia < 0) {
            System.out.println("ERROR: El recargo no puede ser negativo.");
        } else {
            this.recargoUrgencia = recargoUrgencia;
        }
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    public void setNivelPrioridad(int nivelPrioridad) {
        if (nivelPrioridad < 1 || nivelPrioridad > 3) {
            System.out.println("ERROR: El nivel de prioridad debe estar entre 1 y 3.");
        } else {
            this.nivelPrioridad = nivelPrioridad;
        }
    }

    @Override
    public double calcularCostoEntrega() {
        return getCostoBase() + (getDistanciaKm() * 1.00) + recargoUrgencia;
    }

    @Override
    public boolean validarDatos() {

        if (getPesoPaquete() > 10) {
            System.out.println("ERROR: El peso excede el máximo permitido (10 kg).");
            return false;
        }

        if (getHorasVuelo() > 3) {
            System.out.println("ERROR: Las horas exceden el límite permitido (3 horas).");
            return false;
        }

        if (nivelPrioridad < 1 || nivelPrioridad > 3) {
            System.out.println("ERROR: Nivel de prioridad inválido (1-3).");
            return false;
        }

        return true;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("====== DRON EMERGENCIA ======");
        super.mostrarInformacion();
        System.out.println("Carga maxima : 10.0 kg");
        System.out.println("Recargo urgencia : $" + recargoUrgencia);
        System.out.println("Nivel prioridad : " + nivelPrioridad);
    }
}