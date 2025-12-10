

import java.util.*;

public class Dijkstra {

    //Algoritmo de Dijkstra para econtrar el camino minimo con peso
    public static void dijkstra(Grafo grafo, int inicio, int fin) {
    	//iniciamos variables como siempre restandole 1 para sincronizar los vectores con el array para no tener problema de 
    	//desborde 
    	int origen = inicio-1;
    	int destino = fin-1;
    	
        int vertices = grafo.numVertices;
        int[] distancias = new int[vertices];  // distancia desde el origen hasta cada nodo
        boolean[] visitado = new boolean[vertices];  // si el nodo fue visitado
        int[] previo = new int[vertices];  // para guardar el camino mas corto

        // Inicializamos distancias a infinito y previo a -1
        Arrays.fill(distancias, Integer.MAX_VALUE);
        Arrays.fill(previo, -1);
        distancias[origen] = 0;  // La distancia al vertice origen es 0

        // iteramos para encontrar el camino mas corto a cada vertice
        for (int i = 0; i < vertices - 1; i++) {
            // Escogemos el vértice con la distancia mínima que aun no ha sido procesado
            int u = distanciaMinima(distancias, visitado, vertices);
            visitado[u] = true;  // Marcamos este vértice como visitado

            // Revisamos los vertices adyacentes del vértice seleccionado
            for (int v = 0; v < vertices; v++) {
                if (!visitado[v] && grafo.matrizAdyacencia[u][v] != 0 && distancias[u] != Integer.MAX_VALUE &&
                    distancias[u] + grafo.matrizAdyacencia[u][v] < distancias[v]) {
                    distancias[v] = distancias[u] + grafo.matrizAdyacencia[u][v];
                    previo[v] = u;
                }
            }
        }

        // llamamos al metodo para imprimir los resultados
        imprimirCamino(previo, origen, destino, distancias[destino]);
    }
    
 // Metodo para encontrar el vertice con la distancia minima que aun no ha sido visitado
    private static int distanciaMinima(int[] distancias, boolean[] visitado, int vertices) {
        int min = Integer.MAX_VALUE;
        int aux = -1;

        for (int v = 0; v < vertices; v++) {
            if (!visitado[v] && distancias[v] <= min) {
                min = distancias[v];
                aux = v;
            }
        }
        return aux;
    }

    // Metodo para imprimir el camino mas corto desde el origen hasta destino
    private static void imprimirCamino(int[] previo, int origen, int destino, int distancia) {
        if (distancia == Integer.MAX_VALUE) {
            System.out.println("No existe camino entre " + (origen+1) + " y " + (destino+1));
            return;
        }

        System.out.print("El camino más corto de " + (origen+1) + " a " + (destino+1) + " es: ");
        // se le suma 1 de nuevo para que vuelva a mostrar los vertices como son
        
        //llamamos al metodo auiliar del camino
        imprimirRuta(previo, destino);
        System.out.println("\nLa distancia mínima es: " + distancia);
    }

    // Metodo auxiliar para imprimir el camino reconstruido de forma recursiva
    private static void imprimirRuta(int[] previo, int vertice) {
        if (previo[vertice] == -1) { // condicion para cortar la recursividad
            System.out.print("["+(vertice+1)+"]");
            return;
        }
        imprimirRuta(previo, previo[vertice]);
        System.out.print("["+(vertice+1)+"]");
    }
}
