public class DronLiviano extends Dron {

    private double limiteHoras;

    public DronLiviano() {
        setCodigo("DL-000");
        setModelo("LivianoX");
        setDistanciaKm(5);
        setPesoPaquete(2);
        setHorasVuelo(1);
        setCostoBase(3.00);

        this.limiteHoras = 2;
    }

    @Override
    public double calcularCostoEntrega() {
        return getCostoBase() + (getDistanciaKm() * 0.50);
    }

    @Override
    public boolean validarDatos() {
        if (getPesoPaquete() > 5) {
            System.out.println("ERROR: Peso excede el máximo permitido (5 kg).");
            return false;
        }

        if (getHorasVuelo() > limiteHoras) {
            System.out.println("ERROR: Horas de vuelo exceden el límite (2 horas).");
            return false;
        }

        return true;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("====== DRON LIVIANO ======");
        super.mostrarInformacion();
        System.out.println("Carga maxima : 5.0 kg");
        System.out.println("Limite horas : " + limiteHoras + " h");
    }
}