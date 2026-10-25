# Reto2-Clase8
# Sistema de Gestión para Centro de Adopción (Reto 2 - Clase 8)

Proyecto desarrollado en **Java** orientado a objetos para la gestión de un **Centro de Adopción** de animales (perros y gatos), permitiendo registrar, administrar y generar reportes sobre los animales disponibles y las evidencias o procesos relacionados.

## Estructura del Proyecto

El código fuente se encuentra organizado dentro del paquete `reto2` e incluye las siguientes clases principales:

*   **`Animal.java`**: Clase abstracta base que define los atributos comunes (como nombre, edad, raza, estado de adopción) y comportamientos generales de los animales.
*   **`Perro.java`**: Subclase que hereda de `Animal`, implementando atributos o métodos específicos para perros (por ejemplo, nivel de energía o tamaño).
*   **`Gato.java`**: Subclase que hereda de `Animal`, adaptada con características propias de los felinos (como independencia o necesidad de espacio).
*   **`CentroDeAdopcion.java`**: Clase principal o de control encargada de administrar la colección de animales, gestionar registros, ingresos y procesos de adopción.
*   **`Evidencia.java`**: Clase destinada a registrar seguimientos, documentos o pruebas necesarias durante el proceso de adopción o bienestar animal.
*   **`Reporte.java`**: Clase utilitaria o generadora de informes estadísticos y listados sobre el estado actual del centro de adopción.

## Características Principales

*   **Herencia y Polimorfismo**: Uso de una jerarquía de clases con `Animal` como base para tipos específicos (`Perro` y `Gato`).
*   **Gestión de Datos**: Control de altas, bajas y estados de adopción de los animales.
*   **Generación de Informes**: Emisión de reportes claros sobre la población del centro y evidencias de seguimiento.

## Requisitos y Ejecución

1.  Tener instalado **Java Development Kit (JDK)** (versión 8 o superior recomendada).
2.  Compilar las clases desde la raíz del proyecto:
    ```bash
    javac reto2/*.java
    ```
3.  Ejecutar la clase principal de control (o la clase con el método `main` configurado en el centro de adopción).

---
Desarrollado como parte de las actividades prácticas de programación orientada a objetos en Java.
