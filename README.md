# Reto2-Clase8
# Reto 2 · Jornadas de adopción de un refugio

## 1. Integrantes y Aportes
* **Integrante 1:** Diseño de la jerarquía de clases (Base abstracta `Animal`, subclases `Perro` y `Gato`) e interfaz `FichaReporteable`.
* **Integrante 2:** Implementación de la gestión en `Refugio` (`ArrayList`, validaciones de ID y control de adopciones).
* **Integrante 3:** Desarrollo de la clase genérica `Evidencia<T>` y el analizador de visitantes de tamaño fijo.
* **Integrante 4:** Creación de la clase `Main` con los escenarios de prueba base y adicionales.

---

## 2. Identificación del Problema
* **¿Quién necesita la aplicación?** El personal administrativo y operativo de un refugio de animales.
* **¿Qué dificultad tiene?** Carentes de un sistema digital para llevar el control centralizado de los ingresos, distinguir animales disponibles de los adoptados, evitar duplicidades y estimar la carga diaria de trabajo (minutos de cuidado) y afluencia de visitantes.
* **¿Qué debe resolver?** 
  * Registrar perros y gatos con validaciones de edad y formato de ID.
  * Gestionar el historial de adopción conservando al animal en la lista sin permitir doble adopción.
  * Calcular los minutos de cuidado requeridos **solo por los animales disponibles**.
  * Procesar un arreglo de 5 jornadas de visitantes para calcular totales, promedios, máximos y el primer día en caso de empate.
* **¿Qué queda fuera?** Datos personales de adoptantes, expedientes médicos detallados, bases de datos externas, interfaces gráficas y gestores de dependencias como Maven o Gradle.

---

## 3. Reglas de Negocio
1. **IDs únicos y normalizados:** Obligatorios, normalizados con `strip().toUpperCase()` tanto al registrar como al buscar. No se permiten duplicados ni cambios posteriores.
2. **Rango de edad:** Estricto de **0 a 240 meses**.
3. **Minutos diarios de cuidado:**
   * **Perro:** 30 minutos base + 10 minutos si tiene `< 12` meses.
   * **Gato:** 20 minutos base + 5 minutos si tiene `< 12` meses.
   * A los 12 meses exactos no se añade tiempo adicional.
4. **Historial de adopción:** Al adoptar, el animal pasa a `disponible = false`, pero se mantiene en la lista. Intentar adoptarlo de nuevo se rechaza sin alterar el estado.
5. **Arreglo de visitantes:** Exactamente 5 posiciones (índices `0` a `4` para los días `1` a `5`). Ante empates en el máximo, se reporta siempre el **primer día**.

---

## 4. Diagrama UML de Clases

```mermaid
classDiagram
    class FichaReporteable {
        <<interface>>
        +generarFicha() String
    }

    class Animal {
        <<abstract>>
        #String id
        #String nombre
        #int edad
        #boolean disponible
        +Animal(String id, String nombre, int edad)
        +getId() String
        +getNombre() String
        +getEdad() int
        +isDisponible() boolean
        +setDisponible(boolean disponible)
        +abstract calcularMinutosCuidado() int
        +getEspecie() String
        +generarFicha() String
    }

    class Perro {
        +Perro(String id, String nombre, int edad)
        +calcularMinutosCuidado() int
        +getEspecie() String
    }

    class Gato {
        +Gato(String id, String nombre, int edad)
        +calcularMinutosCuidado() int
        +getEspecie() String
    }

    class Evidencia~T~ {
        -String descripcion
        -T contenido
        +Evidencia(String descripcion, T contenido)
        +getDescripcion() String
        +getContenido() T
        +mostrarEvidencia() void
    }

    class AnalizadorVisitantes {
        -int[] visitantes
        +AnalizadorVisitantes(int[] visitantes)
        +getTotal() int
        +getPromedio() double
        +getMaximo() int
        +getPrimerDiaMaximo() int
    }

    class Refugio {
        -List~Animal~ animales
        +Refugio()
        +registrarAnimal(Animal animal) boolean
        +buscarPorId(String id) Animal
        +adoptarAnimal(String id) boolean
        +getListaAnimales() List~Animal~
        +getTotalRegistrados() int
        +getTotalDisponibles() int
        +getTotalAdoptados() int
        +getMinutosCuidadoDisponibles() int
    }

    FichaReporteable <|.. Animal
    Animal <|-- Perro
    Animal <|-- Gato
    Refugio o-- Animal : contiene
    Evidencia ..> Integer : usa
    Evidencia ..> String : usa
