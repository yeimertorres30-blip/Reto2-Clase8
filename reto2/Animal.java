package reto2;

public abstract class Animal implements Reporte {
    protected String id;
    protected String nombre;
    protected int edad;
    protected boolean disponible;

    public Animal(String id, String nombre, int edad) {
        if (id == null || id.strip().isEmpty()) {
            this.id = "INVALIDO";
        } else {
            this.id = id.strip().toUpperCase();
        }

        if (edad < 0 || edad > 240) {
            this.edad = 0;
        } else {
            this.edad = edad;
        }

        this.nombre = (nombre != null) ? nombre.strip() : "";
        this.disponible = true;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public abstract int calcularMinutosCuidado();
    public abstract String getEspecie();

    @Override
    public String generarFicha() {
        return "ID: " + id + " | Nombre: " + nombre + " | Especie: " + getEspecie() +
                " | Edad: " + edad + " meses | Disponible: " + (disponible ? "Sí" : "No") +
                " | Minutos Cuidado: " + calcularMinutosCuidado();
    }
}