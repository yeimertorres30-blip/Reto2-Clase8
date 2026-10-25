package reto2;

public class Gato extends Animal {

    public Gato(String id, String nombre, int edad) {
        super(id, nombre, edad);
    }

    @Override
    public int calcularMinutosCuidado() {
        int minutos = 20;
        if (getEdad() < 12) {
            minutos += 5;
        }
        return minutos;
    }
}