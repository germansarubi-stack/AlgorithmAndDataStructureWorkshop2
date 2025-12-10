
import java.util.List;
import java.util.*;

public class GrafoAciclico {
	// Método para imprimir todos los caminos acíclicos desde 'a' hasta 'b"
    public static void imprimirTodosCaminoAciclico(Grafo grafo, int a, int b) {
    	//varibales para sincronizar las posiciones de arrays con los vertices
    	int x = a-1; 
    	int y = b-1;
    	//variables aux y una lista para guardar los nodos correspondientes
        boolean[] visitado = new boolean[grafo.numVertices];
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(x);
        //llamamos al metdodo recursivo para resolver el problema con nuevos parametros
        caminoAciclico(grafo, x, y, visitado, lista);
    }

    // Método recursivo para encontrar todos los caminos acíclicos  
    public static void caminoAciclico(Grafo grafo, int a, int b, boolean[] visitado, List<Integer> localLista) {
    	//condicional para cortar la recursividad
    	//tambien donde se imprime los caminos aciclicos
        if (a == b) {
        	for (int nodo : localLista) {
	            System.out.print("["+ (nodo+1) +"]" + " "); // le sumamos 1 al nodo para sincronizar el array con los vertices
	        }
        	System.out.println();
            return;
        }

        visitado[a] = true;
        
        //bucle de verificacion de aristas y actualizacion de variables
        for (int i = 0; i <grafo.numVertices; i++) {
            if (grafo.matrizAdyacencia[a][i] !=0 && !visitado[i]) {
            	//agregamos a la lista todos los vertices que cumplan la condicion
                localLista.add(i);
                //llamado recursivo con valores cada vez mas cercanos al final
                caminoAciclico(grafo, i, b, visitado, localLista);
                //vaciamos la lista para analizar otro camino
                localLista.remove(localLista.size()-1);
            }
        }

        visitado[a] = false;
    }
}
