package reto2;

import java.util.Locale;

public abstract class Animal implements Reporte {
    private String id;
    private String nombre;
    private int edad;
    private boolean disponible;

    public Animal(String id, String nombre, int edad) {
        if (id == null || id.strip().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede ser nulo o en blanco.");
        }
        if (nombre == null || nombre.strip().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o en blanco.");
        }
        if (edad < 0 || edad > 240) {
            throw new IllegalArgumentException("La edad debe estar entre 0 y 240 meses.");
        }

        this.id = id.strip().toUpperCase(Locale.ROOT);
        this.nombre = nombre.strip();
        this.edad = edad;
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

    @Override
    public String generarFicha() {
        return "ID: " + id +
                ", Nombre: " + nombre +
                ", Especie: " + this.getClass().getSimpleName() +
                ", Edad: " + edad + " meses" +
                ", Disponible: " + (disponible ? "Sí" : "No") +
                ", Minutos de cuidado: " + (disponible ? calcularMinutosCuidado() : 0);
    }
}