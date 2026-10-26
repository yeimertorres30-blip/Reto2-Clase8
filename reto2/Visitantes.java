package reto2;

public class Visitantes {
    private int[] visitantes;

    public Visitantes(int[] visitantes) {
        if (visitantes == null || visitantes.length != 5) {
            this.visitantes = new int[5]; // Inicializa en ceros por seguridad
        } else {
            this.visitantes = visitantes;
        }
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < visitantes.length; i++) {
            total += visitantes[i];
        }
        return total;
    }

    public double getPromedio() {
        if (visitantes.length == 0) return 0.0;
        return (double) getTotal() / visitantes.length;
    }

    public int getMaximo() {
        if (visitantes.length == 0) return 0;
        int max = visitantes[0];
        for (int i = 1; i < visitantes.length; i++) {
            if (visitantes[i] > max) {
                max = visitantes[i];
            }
        }
        return max;
    }

    public int getPrimerDiaMaximo() {
        int max = getMaximo();
        for (int i = 0; i < visitantes.length; i++) {
            if (visitantes[i] == max) {
                return i + 1; // Retorna el día de 1 a 5
            }
        }
        return 0;
    }
}