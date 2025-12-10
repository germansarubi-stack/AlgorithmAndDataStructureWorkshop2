
public class MainGrafo {
	public static void main(String[] args) {
        int numVertices = 13; 
        Grafo grafo = new Grafo(numVertices);
        
        // agregamos aristas con los pesos dados en la situacion problematica
        grafo.agregarArista(1, 2, 200);  // (d1, d2, 200)
        grafo.agregarArista(1, 13, 250); // (d1, d3, 250)
        grafo.agregarArista(1, 9, 290);  // (d1, d9, 290)
        grafo.agregarArista(2, 6, 360);  // (d2, d6, 360)
        grafo.agregarArista(2, 3, 190);  // (d2, d3, 190)
        grafo.agregarArista(3, 6, 250);  // (d3, d6, 250)
        grafo.agregarArista(3, 5, 190);  // (d3, d5, 190)
        grafo.agregarArista(3, 1, 300);  // (d3, d1, 300)
        grafo.agregarArista(4, 3, 180);  // (d4, d3, 180)
        grafo.agregarArista(5, 6, 300);  // (d5, d6, 300)
        grafo.agregarArista(5, 10, 400);  // (d5, d10, 400)
        grafo.agregarArista(6, 11, 350); // (d6, d11, 350)
        grafo.agregarArista(6, 12, 300); // (d6, d12, 300)
        grafo.agregarArista(7, 4, 300);  // (d7, d4, 300)
        grafo.agregarArista(7, 3, 250);  // (d7, d3, 250)
        grafo.agregarArista(7, 1, 150);  // (d7, d1, 150)
        grafo.agregarArista(8, 7, 200);  // (d8, d7, 200)
        grafo.agregarArista(8, 1, 220);  // (d8, d1, 220)
        grafo.agregarArista(9, 8, 180);  // (d9, d8, 180)
        grafo.agregarArista(9, 13, 180); // (d9, d13, 180)
        grafo.agregarArista(10, 4, 200);  // (d10, d4, 200)
        grafo.agregarArista(11, 10, 700); // (d11, d10, 700)
        grafo.agregarArista(11, 5, 200); // (d11, d5, 200)
        grafo.agregarArista(12, 2, 150); // (d12, d2, 150)
        grafo.agregarArista(13, 12, 100);// (d13, d12, 100)
        grafo.agregarArista(13, 2, 200); // (d13, d2, 200)
        
        //Mostramos la matriz de adyacencia
        grafo.mostrarMatrizAdyacencia();
        System.out.println();

        //Buscamos el camino minimo sin peso y mostramos por pantalla
        CaminosMinimos.caminoMinimoSinPeso(grafo,1,10);
        System.out.println();
        

        System.out.println("Todos los caminos acíclicos desde d1 hasta d13 son:");
        GrafoAciclico.imprimirTodosCaminoAciclico(grafo,1, 13);
        System.out.println();
        
        //Distancia minima con peso algoritmo de Dijkstra
        Dijkstra.dijkstra(grafo,1, 10);
    }
}
