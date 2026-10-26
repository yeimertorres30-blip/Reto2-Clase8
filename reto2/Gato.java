package reto2;

public class Gato extends Animal {

    public Gato(String id, String nombre, int edad) {
        super(id, nombre, edad);
    }

    @Override
    public int calcularMinutosCuidado() {
        int base = 20;
        if (edad < 12) {
            base += 5;
        }
        return base;
    }

    @Override
    public String getEspecie() {
        return "Gato";
    }
}