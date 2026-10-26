package reto2;

public class Evidencia<T> {
    private String descripcion;
    private T contenido;

    public Evidencia(String descripcion, T contenido) {
        this.descripcion = descripcion;
        this.contenido = contenido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public T getContenido() {
        return contenido;
    }

    public void mostrarEvidencia() {
        System.out.println("--- EVIDENCIA ---");
        System.out.println("Descripción: " + descripcion);
        System.out.println("Contenido: " + contenido);
    }
}