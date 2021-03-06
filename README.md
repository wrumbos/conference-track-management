# conference-track-management

Software para la organizaci贸n de conferencias

## T贸picos
*  **[馃摑 Requerimientos](#-requerimientos)**
*  **[馃殌 Solucion](#-Solucion)**
*  **[馃梻 Estructura de Directorios](#-estructura-de-directorios)**
*  **[馃憮 Pruebas Funcionales](#-pruebas-funcionales)**
*  **[鈿欙笍 Otros](#%EF%B8%8F-otros)**

## 馃摑 Requerimientos
```
Java 8+
Junit 4.13.2
```
## 馃殌 Solucion
La soluci贸n de este problema consta de dos partes.
1. la primera parte se busc贸 una soluci贸n al problema planteado se realiz贸 una adecuaci贸n propia al algoritmo de programaci贸n
dinamica [Knapsack problem](https://en.wikipedia.org/wiki/Knapsack_problem), esto debido a que se disponen de m煤ltiples formas de
organizar las conferencia encontrando similitud en lo planteado y solucionado con este algoritmo.
2. la segunda parte consta lograr primeramente lograr tomar la data de un archivo `.csv` clasificarla y pasarla a un objeto
a esta parte se le denomino `match`, luego un proceso de validaci贸n de toda la informaci贸n encontrada en el archivo
`validate`, para seguir cla organizaci贸n de toda la data necesaria para ser procesada por el algoritmo `prosecute`,
y por ultimo mostrar la data ya procesada y organizada.

**Nota:**
Para el proceso de `match` se utilizo una implementaci贸n del patron de diseno
[Chain-of-responsibility pattern](https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern).

## 馃梻 Estructura de Directorios
```
馃摝 conference-track-management   
鈹?
鈹斺攢馃搧 resources            Archivos utilizados para la ejecuci贸n y prueba del sistema
鈹?  
鈹斺攢馃搧 src                  C贸digo fuente
鈹? 鈹?
鈹? 鈹斺攢馃搧 java               M贸dulos ra铆ces para el software
鈹? 鈹?
鈹? 鈹斺攢馃搧 test               Pruebas funcionales del software
鈹?
鈹斺攢馃搫 README.md            Documentacion del software

```
## 馃憮 Pruebas funcionales
* Como pruebas funcionales se desarrollaron los siguientes Tests:
1. Datos correctos.
2. Excede el tiempo Maximo.
3. Carecer el tiempo de las charlas.
4. Titulos con numeros.
5. Charlas menores de 5 minutos.
6. Tipo de tiempo correcto.

## 鈿欙笍 Otros
### Ejecutar
1. Para Ejecutar el software sin exportar el proyecto alg煤n IDE se puede usar como referencia los siguientes comandos:
>Compilar
```
javac example.java
```
>Ejecutar
```
java example
```
2. Para Ejecutar las pruebas funcionales sin exportar el proyecto alg煤n IDE se puede usar como referencia los siguientes comandos:
>Compilar
```
javac -d /absolute/path/for/compiled/classes -cp /absolute/path/to/junit-4.12.jar /absolute/path/to/example.java
```
>Ejecutar
```
java -cp /absolute/path/for/compiled/classes:/absolute/path/to/junit-4.12.jar:/absolute/path/to/hamcrest-core-1.3.jar org.junit.runner.JUnitCore your.package.example
```
