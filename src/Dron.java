public abstract class Dron {

    // Atributos, encapsulamiento
    private String codigo;
    private String modelo;
    private double distanciaKm;
    private double pesoPaquete;
    private double horasVuelo;
    private double costoBase;

    public Dron() {
    }

    public Dron(String codigo, String modelo, double distanciaKm, double pesoPaquete, double horasVuelo, double costoBase) {
        setCodigo(codigo);
        setModelo(modelo);
        setDistanciaKm(distanciaKm);
        setPesoPaquete(pesoPaquete);
        setHorasVuelo(horasVuelo);
        setCostoBase(costoBase);
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public double getPesoPaquete() {
        return pesoPaquete;
    }

    public double getHorasVuelo() {
        return horasVuelo;
    }

    public double getCostoBase() {
        return costoBase;
    }

    // Setters con validación
    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            System.out.println("ERROR: El código no puede ser vacío.");
        } else {
            this.codigo = codigo;
        }
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            System.out.println("ERROR: El modelo no puede ser vacío.");
        } else {
            this.modelo = modelo;
        }
    }

    public void setDistanciaKm(double distanciaKm) {
        if (distanciaKm <= 0) {
            System.out.println("ERROR: La distancia debe ser mayor a 0.");
        } else {
            this.distanciaKm = distanciaKm;
        }
    }

    public void setPesoPaquete(double pesoPaquete) {
        if (pesoPaquete <= 0) {
            System.out.println("ERROR: El peso debe ser mayor a 0.");
        } else {
            this.pesoPaquete = pesoPaquete;
        }
    }

    public void setHorasVuelo(double horasVuelo) {
        if (horasVuelo <= 0) {
            System.out.println("ERROR: Las horas de vuelo deben ser mayores a 0.");
        } else {
            this.horasVuelo = horasVuelo;
        }
    }

    public void setCostoBase(double costoBase) {
        if (costoBase <= 0) {
            System.out.println("ERROR: El costo base debe ser mayor a 0.");
        } else {
            this.costoBase = costoBase;
        }
    }

    // Métodos abstractos obligatorios
    public abstract double calcularCostoEntrega();

    public abstract boolean validarDatos();

    // Método concreto
    public void mostrarInformacion() {
        System.out.println("Codigo : " + codigo);
        System.out.println("Modelo : " + modelo);
        System.out.println("Distancia : " + distanciaKm + " km");
        System.out.println("Peso paquete : " + pesoPaquete + " kg");
        System.out.println("Horas vuelo : " + horasVuelo + " h");
        System.out.println("Costo base : $" + costoBase);
        System.out.println("Costo entrega: $" + calcularCostoEntrega());
    }
}