# Taller de algoritmos y estructura de datos 2

Repositorio con implementaciones en Java para ejercicios del taller.

## Descripción
Colección de prácticas y ejemplos de estructuras y algoritmos: árboles binarios, grafos y caminos mínimos, hashing, Huffman y un algoritmo genético.

## Estructura del proyecto
- Algoritmo genetico/
  - AlgoritmoGenetico.java
  - MainAlgoritmoGenetico.java

- Arbol binario, caminos minimos, Dijkstra, grafo, grafo aciclico/
  - ArbolBinario.java
  - CaminosMinimos.java
  - Dijkstra.java
  - Grafo.java
  - GrafoAciclico.java
  - MainGrafo.java

- Funcion, tabla y coliciones Hash/
  - ColisionesHashingAbierto.java
  - FuncionHash.java
  - TablaHash.java

- Huffman/
  - CodigoHuffman.java
  - HuffmanNodo.java
  - MainHuffman.java

## Cómo compilar
Desde la raíz del proyecto (la carpeta donde está este README) puedes compilar todos los archivos Java y colocar los .class en una carpeta `out`:

PowerShell (recomendado en Windows):

```powershell
mkdir out
Get-ChildItem -Recurse -Filter *.java | ForEach-Object { javac -d out $_.FullName }
```

O, compilando por carpeta (ejemplo):

```powershell
javac -d out "Algoritmo genetico\*.java"
javac -d out "Huffman\*.java"
javac -d out "Arbol binario, caminos minimos, Dijkstra, grafo, grafo aciclico\*.java"
javac -d out "Funcion, tabla y coliciones Hash\*.java"
```

## Cómo ejecutar
Ejecuta la clase que tenga el `main` indicando la carpeta `out` en el classpath. Por ejemplo, para ejecutar `MainHuffman`:

```powershell
java -cp out MainHuffman
```

Para otros `main`, sustituye el nombre de la clase principal, por ejemplo `MainAlgoritmoGenetico` o `MainGrafo`.

## Notas
- Si los archivos contienen paquetes, ajusta los comandos de compilación/ejecución según la estructura de paquetes.
- Recomiendo usar una IDE (IntelliJ IDEA o VS Code con extensión Java) para ejecutar y depurar más fácilmente.

## Próximos pasos sugeridos
- Añadir ejemplos de entrada/salida para cada `main`.
- Documentar la complejidad y casos de prueba para cada algoritmo.
- Añadir un script `build.ps1` para automatizar compilación y ejecución.

---
Generado automáticamente: README básico para orientarte sobre el contenido y cómo compilar/ejecutar los ejercicios.