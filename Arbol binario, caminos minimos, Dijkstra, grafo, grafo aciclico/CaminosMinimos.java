
import java.util.*;

public class CaminosMinimos {
	//metodo para determinar todos los caminos 
	public static void caminoMinimoSinPeso(Grafo grafo, int origen, int destino){
		//inciamos variables y le restamos 1 a los parametros enviados para sincronizar 
		//el array con los vertices y evitar el desborde 
		int orig = origen-1;
		int dest = destino-1;
	
		//creamos objetos arrays auxiliares con el tamaño de vertices correspondientes
		//implementamos una variable lista tipo cola para añadir elementos 
		Queue<Integer> procesar = new LinkedList<>();
		int [] anterior = new int[(grafo.numVertices)]; //para recontruir el camino
		boolean[] visitado = new boolean[(grafo.numVertices)]; //marcar los nodos visitados
		int[] distancia = new int[grafo.numVertices]; //guardar la distancia del inicio hasta el final
		
		//inicializamos los objetos
		procesar.add(orig); // se agreaga a la cola
		visitado[orig] = true;
		anterior[orig] = -1; //indica que no tiene
		distancia[orig] = 0;
		
		//creamos un ciclo para buscar los caminos mientras la cola no este vacia
		while (!procesar.isEmpty()) { 
			int verticeActual=procesar.poll();//quita el nodo del principio de la lista y guarda en la variable
			
			//ciclo para verificar aristas
			for (int vecino=0; vecino<grafo.numVertices; vecino++) {
				//condicional para actualizar las variables aux si la arista tiene peso y no fue visitado
				if (grafo.matrizAdyacencia[verticeActual][vecino]!=0 && !visitado[vecino]) {
					visitado[vecino]=true;
					anterior[vecino]=verticeActual;		
					distancia[vecino] = distancia[verticeActual]+1;
					procesar.add(vecino);
					
					//si llegamos al nodo de destino se termina la busqueda y llamamos al metodo para imprimir
					if (vecino == dest) {
                        imprimirCamino(anterior, origen, destino);
                        System.out.println("Distancia mínima (número de saltos): " + distancia[dest]);
                        return;
					}
				}
			}
		}
		// si no se encuentra un camino
        System.out.println("No hay camino entre "+"d" + origen + " y "+"d" + destino);
	}

	//metodo para imprimir el camino
	private static void imprimirCamino(int[] anterior, int origen, int destino) {
		//lo mismo que antes guardamos los parametros restandole 1 para sincronizar con el array
		int ori = origen-1;
		int des = destino-1;
		
		//varibale lista del tipo cola como array de integer
		 List<Integer> camino = new ArrayList<>();
	        int actual = des;

	        // reconstruimos el camino utilizando el array de anteriores
	        while (actual != -1) {
	            camino.add(actual);
	            actual = anterior[actual];
	        }

	        // invertimos la lista para obtener el camino en el orden correcto
	        Collections.reverse(camino);

	        System.out.print("Camino mínimo (sin pesos) desde "+"d" + origen + " hasta "+"d" + destino + ": ");
	        for (int nodo : camino) {
	            System.out.print("["+ (nodo+1) +"]" + " "); // le sumamos 1 al nodo para sincronizar el array con los vertices
	        }
	        System.out.println();
	    }
		
}
