package reto2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class CentroDeAdopcion {
    private List<Animal> animales;
    private int[] visitantes;

    public CentroDeAdopcion() {
        this.animales = new ArrayList<>();
        this.visitantes = new int[5];
    }


    public boolean registrarAnimal(Animal animal) {
        if (animal == null) return false;

        for (Animal a : animales) {
            if (a.getId().equals(animal.getId())) {
                return false;
            }
        }

        animales.add(animal);
        return true;
    }

    public Animal buscarPorId(String idBuscado) {
        if (idBuscado == null) return null;
        String idNorm = idBuscado.strip().toUpperCase(Locale.ROOT);

        for (Animal a : animales) {
            if (a.getId().equals(idNorm)) {
                return a;
            }
        }
        return null;
    }

    public boolean adoptarAnimal(String idBuscado) {
        Animal animal = buscarPorId(idBuscado);
        if (animal == null) {
            System.out.println("No encontrado");
            return false;
        }

        if (!animal.isDisponible()) {
            return false;
        }

        animal.setDisponible(false);
        return true;
    }

    public List<Animal> getAnimales() {
        return Collections.unmodifiableList(animales);
    }


    public boolean registrarVisitantesDia(int diaIndex, int cantidad) {
        if (diaIndex < 0 || diaIndex >= 5) {
            return false;
        }
        if (cantidad < 0 || cantidad > 100) {
            return false;
        }
        visitantes[diaIndex] = cantidad;
        return true;
    }

    public int getVisitantesDia(int diaIndex) {
        if (diaIndex < 0 || diaIndex >= 5) return -1;
        return visitantes[diaIndex];
    }

    public int calcularTotalVisitantes() {
        int total = 0;
        for (int v : visitantes) {
            total += v;
        }
        return total;
    }

    public double calcularPromedioVisitantes() {
        return calcularTotalVisitantes() / 5.0;
    }

    public int calcularMaximoVisitantes() {
        if (visitantes.length == 0) return 0;
        int max = visitantes[0];
        for (int v : visitantes) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public int calcularPrimerDiaMaximoVisitantes() {
        int max = calcularMaximoVisitantes();
        for (int i = 0; i < visitantes.length; i++) {
            if (visitantes[i] == max) {
                return i + 1;
            }
        }
        return -1;
    }

    public int contarRegistrados() {
        return animales.size();
    }

    public int contarDisponibles() {
        int count = 0;
        for (Animal a : animales) {
            if (a.isDisponible()) count++;
        }
        return count;
    }

    public int contarAdoptados() {
        int count = 0;
        for (Animal a : animales) {
            if (!a.isDisponible()) count++;
        }
        return count;
    }

    public int calcularMinutosCuidadoDisponibles() {
        int totalMinutos = 0;
        for (Animal a : animales) {
            if (a.isDisponible()) {
                totalMinutos += a.calcularMinutosCuidado();
            }
        }
        return totalMinutos;
    }
}