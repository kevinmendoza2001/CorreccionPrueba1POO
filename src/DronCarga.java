public class DronCarga extends Dron {

    private double costoPorKg;

    // Constructor sin parámetros
    public DronCarga() {
        setCodigo("DC-000");
        setModelo("CargaMax");
        setDistanciaKm(5);
        setPesoPaquete(2);
        setHorasVuelo(1);
        setCostoBase(6.00);

        this.costoPorKg = 0.70;
    }

    public double getCostoPorKg() {
        return costoPorKg;
    }

    public void setCostoPorKg(double costoPorKg) {
        if (costoPorKg <= 0) {
            System.out.println("ERROR: El costo por Kg debe ser mayor a 0.");
        } else {
            this.costoPorKg = costoPorKg;
        }
    }

    @Override
    public double calcularCostoEntrega() {
        return getCostoBase() + (getDistanciaKm() * 0.70) + (getPesoPaquete() * costoPorKg);
    }

    @Override
    public boolean validarDatos() {

        if (getPesoPaquete() > 30) {
            System.out.println("ERROR: El peso excede el máximo permitido (30 kg).");
            return false;
        }

        if (getHorasVuelo() > 5) {
            System.out.println("ERROR: Las horas exceden el límite permitido (5 horas).");
            return false;
        }

        return true;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("====== DRON CARGA ======");
        super.mostrarInformacion();
        System.out.println("Carga maxima : 30.0 kg");
        System.out.println("Costo por Kg : $" + costoPorKg);
    }
}