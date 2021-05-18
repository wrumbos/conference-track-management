# conference-track-management

Software para la organización de conferencias

## Tópicos
*  **[📝 Requerimientos](#-requerimientos)**
*  **[🚀 Solucion](#-Solucion)**
*  **[🗂 Estructura de Directorios](#-estructura-de-directorios)**
*  **[👓 Pruebas Funcionales](#-pruebas-funcionales)**
*  **[⚙️ Otros](#%EF%B8%8F-otros)**

## 📝 Requerimientos
```
Java 8+
Junit 4.13.2
```
## 🚀 Solucion
La solución de este problema consta de dos partes.
1. la primera parte se buscó una solución al problema planteado se realizó una adecuación propia al algoritmo de programación
dinamica [Knapsack problem](https://en.wikipedia.org/wiki/Knapsack_problem), esto debido a que se disponen de múltiples formas de
organizar las conferencia encontrando similitud en lo planteado y solucionado con este algoritmo.
2. la segunda parte consta lograr primeramente lograr tomar la data de un archivo `.csv` clasificarla y pasarla a un objeto
a esta parte se le denomino `match`, luego un proceso de validación de toda la información encontrada en el archivo
`validate`, para seguir cla organización de toda la data necesaria para ser procesada por el algoritmo `prosecute`,
y por ultimo mostrar la data ya procesada y organizada.

**Nota:**
Para el proceso de `match` se utilizo una implementación del patron de diseno
[Chain-of-responsibility pattern](https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern).

## 🗂 Estructura de Directorios
```
📦 conference-track-management   
│
└─📁 resources            Archivos utilizados para la ejecución y prueba del sistema
│  
└─📁 src                  Código fuente
│ │
│ └─📁 java               Módulos raíces para el software
│ │
│ └─📁 test               Pruebas funcionales del software
│
└─📄 README.md            Documentacion del software

```
## 👓 Pruebas funcionales
* Como pruebas funcionales se desarrollaron los siguientes Tests:
1. Datos correctos.
2. Excede el tiempo Maximo.
3. Carecer el tiempo de las charlas.
4. Titulos con numeros.
5. Charlas menores de 5 minutos.
6. Tipo de tiempo correcto.

## ⚙️ Otros
### Ejecutar
1. Para Ejecutar el software sin exportar el proyecto algún IDE se puede usar como referencia los siguientes comandos:
>Compilar
```
javac example.java
```
>Ejecutar
```
java example
```
2. Para Ejecutar las pruebas funcionales sin exportar el proyecto algún IDE se puede usar como referencia los siguientes comandos:
>Compilar
```
javac -d /absolute/path/for/compiled/classes -cp /absolute/path/to/junit-4.12.jar /absolute/path/to/example.java
```
>Ejecutar
```
java -cp /absolute/path/for/compiled/classes:/absolute/path/to/junit-4.12.jar:/absolute/path/to/hamcrest-core-1.3.jar org.junit.runner.JUnitCore your.package.example
```
