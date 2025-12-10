

//Creamos el objeto grafo que contiene el numero de vertices y la matriz de adyacencia
public class Grafo {
	public int numVertices; // numero de vertices en el grafo
	public int[][] matrizAdyacencia; // matriz para reprecentar las aristas entre vertices

	// contructor que inica el grafo con un numero de vertices enviado como parametro
	public Grafo(int numVertices) {
		this.numVertices = numVertices; // indicamos al objeto grafo que este es el valor de la variable
		matrizAdyacencia = new int[numVertices][numVertices]; // iniciamos la matriz NxN con el parametro enviado  

		// recorremos la matriz y valuamos todas las aristas en 0
	    for (int i = 0; i < numVertices; i++) {
	    	for (int j = 0; j < numVertices; j++) {
	           matrizAdyacencia[i][j] = 0;  
	        }
	    }
	}

	// metodo para agregar aritas o adyacencia entre vertices
	// variable inicio es el vertice de donde sale la arista
	//varibale fin es el vertice donde llega la arita 
	// variable distancia es el peso de la arista medido en Km que hay entre los vertices indicados
	public void agregarArista(int inicio, int fin, int distancia) {
		matrizAdyacencia[inicio-1][fin-1] = distancia; // guarda en la posicion de la matriz indicada el peso de la arista
														// le restamos 1 para evitar el error de extend of bone
	}
	
	
	// metodo para imprimir la matriz de adyacencias
    public void mostrarMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencias:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    

    
}


