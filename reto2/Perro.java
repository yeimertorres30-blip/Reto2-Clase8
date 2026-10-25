package reto2;

public class Perro extends Animal {

    public Perro(String id, String nombre, int edad) {
        super(id, nombre, edad);
    }

    @Override
    public int calcularMinutosCuidado() {
        int minutos = 30;
        if (getEdad() < 12) {
            minutos += 10;
        }
        return minutos;
    }
}