package reto2;

public class Reto2 {
    public static void main(String[] args) {
        System.out.println(" EJECUCIÓN DEL ESCENARIO BASE OBLIGATORIO");

        CentroDeAdopcion refugio = new CentroDeAdopcion();

        // Registrar perro P-01 (Luna, 6 meses) y gato G-01 (Milo, 18 meses)
        Perro p1 = new Perro("P-01", "Luna", 6);   // < 12 meses -> 30 + 10 = 40 min
        Gato g1 = new Gato("G-01", "Milo", 18);     // >= 12 meses -> 20 min

        refugio.registrarAnimal(p1);
        refugio.registrarAnimal(g1);

        System.out.println("Animales registrados inicialmente:");
        for (Animal a : refugio.getListaAnimales()) {
            System.out.println(" - " + a.generarFicha());
        }

        // Adoptar P-01 por primera vez
        boolean adopcion1 = refugio.adoptarAnimal("P-01");
        System.out.println("\nAdoptar P-01 (1ra vez): " + (adopcion1 ? "Aceptada" : "Rechazada") +
                " | ¿P-01 disponible?: " + p1.isDisponible());

        // Adoptar P-01 nuevamente
        boolean adopcion2 = refugio.adoptarAnimal("P-01");
        System.out.println("Adoptar nuevamente P-01: " + (adopcion2 ? "Aceptada" : "Rechazada") +
                " | ¿P-01 disponible?: " + p1.isDisponible());

        // Resumen final
        System.out.println("\n--- Resumen Final del Refugio ---");
        System.out.println("Registrados: " + refugio.getTotalRegistrados());
        System.out.println("Disponibles: " + refugio.getTotalDisponibles());
        System.out.println("Adoptados: " + refugio.getTotalAdoptados());
        System.out.println("Minutos diarios de cuidado (disponibles): " + refugio.getMinutosCuidadoDisponibles() + " minutos");

        // Evidencia numérica con Clase Genérica
        Evidencia<Integer> evidenciaNum = new Evidencia<>("Total de adoptados", refugio.getTotalAdoptados());
        evidenciaNum.mostrarEvidencia();

        // Análisis de Visitantes [5, 0, 8, 8, 4]
        int[] visitas = {5, 0, 8, 8, 4};
        Visitantes analizador = new Visitantes(visitas);
        System.out.println("\n--- Análisis de Visitantes ---");
        System.out.println("Total visitantes: " + analizador.getTotal());
        System.out.println("Promedio: " + analizador.getPromedio());
        System.out.println("Máximo: " + analizador.getMaximo());
        System.out.println("Primer día del máximo: Día " + analizador.getPrimerDiaMaximo());

        // Evidencia textual con Clase Genérica
        Evidencia<String> evidenciaTxt = new Evidencia<>("Conclusión del reto", "Escenario base ejecutado exitosamente sin errores.");
        evidenciaTxt.mostrarEvidencia();


        System.out.println(" PRUEBAS ADICIONALES");

        CentroDeAdopcion refugioPruebas = new CentroDeAdopcion();
        boolean duplicado = refugioPruebas.registrarAnimal(new Perro("  p-01 ", "Test1", 5));
        boolean duplicado2 = refugioPruebas.registrarAnimal(new Perro("P-01", "Test2", 5));
        System.out.println("Registro ID duplicado con espacios/minúsculas: " + (duplicado2 ? "Aceptado" : "Rechazado (Correcto)"));

        // Búsqueda ID inexistente
        Animal busqueda = refugioPruebas.buscarPorId("Z-99");
        if (busqueda == null) {
            System.out.println("Búsqueda Z-99: No encontrado");
        }

        // Reglas de edad exactas (11 vs 12 meses)
        Perro p11 = new Perro("P11", "P11", 11);
        Perro p12 = new Perro("P12", "P12", 12);
        Gato g11 = new Gato("G11", "G11", 11);
        Gato g12 = new Gato("G12", "G12", 12);

        System.out.println("\nPruebas de edad límite:");
        System.out.println("Perro 11 meses (esperado 40): " + p11.calcularMinutosCuidado());
        System.out.println("Perro 12 meses (esperado 30): " + p12.calcularMinutosCuidado());
        System.out.println("Gato 11 meses (esperado 25): " + g11.calcularMinutosCuidado());
        System.out.println("Gato 12 meses (esperado 20): " + g12.calcularMinutosCuidado());
    }
}