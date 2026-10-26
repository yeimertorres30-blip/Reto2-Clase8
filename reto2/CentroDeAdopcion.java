package reto2;

import java.util.ArrayList;
import java.util.List;

public class CentroDeAdopcion {
    private List<Animal> animales;

    public CentroDeAdopcion() {
        this.animales = new ArrayList<>();
    }

    public boolean registrarAnimal(Animal animal) {
        if (animal == null || animal.getId().equals("INVALIDO")) {
            return false; // Rechaza datos inválidos
        }
        // Validar si el ID ya existe normalizado
        if (buscarPorId(animal.getId()) != null) {
            return false; // ID duplicado rechazado
        }
        animales.add(animal);
        return true;
    }

    public Animal buscarPorId(String id) {
        if (id == null || id.strip().isEmpty()) {
            return null;
        }
        String idBuscado = id.strip().toUpperCase();
        for (int i = 0; i < animales.size(); i++) {
            Animal a = animales.get(i);
            if (a.getId().equals(idBuscado)) {
                return a;
            }
        }
        return null;
    }

    public boolean adoptarAnimal(String id) {
        Animal animal = buscarPorId(id);
        if (animal == null) {
            System.out.println("No encontrado");
            return false;
        }
        if (!animal.isDisponible()) {
            return false; // Ya adoptado, se rechaza sin cambiar estado
        }
        animal.setDisponible(false);
        return true;
    }

    public List<Animal> getListaAnimales() {
        return new ArrayList<>(animales); // Encapsulamiento defensivo
    }

    public int getTotalRegistrados() {
        return animales.size();
    }

    public int getTotalDisponibles() {
        int count = 0;
        for (int i = 0; i < animales.size(); i++) {
            if (animales.get(i).isDisponible()) {
                count++;
            }
        }
        return count;
    }

    public int getTotalAdoptados() {
        int count = 0;
        for (int i = 0; i < animales.size(); i++) {
            if (!animales.get(i).isDisponible()) {
                count++;
            }
        }
        return count;
    }

    public int getMinutosCuidadoDisponibles() {
        int totalMinutos = 0;
        for (int i = 0; i < animales.size(); i++) {
            Animal a = animales.get(i);
            if (a.isDisponible()) {
                totalMinutos += a.calcularMinutosCuidado();
            }
        }
        return totalMinutos;
    }
}