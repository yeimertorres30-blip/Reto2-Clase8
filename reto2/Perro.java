package reto2;

public class Perro extends Animal {

    public Perro(String id, String nombre, int edad) {
        super(id, nombre, edad);
    }

    @Override
    public int calcularMinutosCuidado() {
        int base = 30;
        if (edad < 12) {
            base += 10;
        }
        return base;
    }

    @Override
    public String getEspecie() {
        return "Perro";
    }
}