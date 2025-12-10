
import java.util.PriorityQueue;//para organizar segun su valor
import java.util.Map;//para almacenar elementos en pares clave-valor
import java.util.HashMap;//utilozamos en conjunto con el map para que no tengan orden especifico y no acepte duplicados ni nulos
import java.util.Scanner;//leer por consola

public class MainHuffman {
	 public static void main(String[] args) {
	    	
	    	//iniciamos el scanner
	        Scanner scanner = new Scanner(System.in);
	        
	        //leer el texto para codificar
	        System.out.print("Ingrese el texto a codificar: ");
	        String texto = scanner.nextLine();
	        
	        //contamos la frecuencia de cada caracter en el texto
	        Map<Character, Integer> mapFrecuencia = new HashMap<>();
	        for (char c : texto.toCharArray()) {
	            mapFrecuencia.put(c, mapFrecuencia.getOrDefault(c, 0) + 1);
	        }

	        //creamos una cola de prioridad para construir el arbol de Huffman segun su valor
	        PriorityQueue<HuffmanNodo> cola = new PriorityQueue<>(new comparadorDeFrecuencia());
	        
	        //utilizamos map para crear todos los nodos utilizando la llave y su respectivo valor 
	        //y los vamos colocando en la cola creada anteriormente
	        for (Map.Entry<Character, Integer> entrada : mapFrecuencia.entrySet()) {
	            HuffmanNodo nodo = new HuffmanNodo();
	            nodo.caracter = entrada.getKey();
	            nodo.frequencia = entrada.getValue();
	            nodo.izq = null;
	            nodo.der = null;
	            cola.add(nodo);
	        }

	        //construimos el arbol de Huffman utilizando la cola de prioridad
	        //mientras la cola sea mayor a 1, guarda el ultimo valor izq y der en un nodo aux
	        while (cola.size() > 1) {
	            HuffmanNodo izq = cola.poll();
	            HuffmanNodo der = cola.poll();

	        //cramos un nodo padre y lo agregamos a la cola    
	            HuffmanNodo padre = new HuffmanNodo();
	            padre.frequencia = izq.frequencia + der.frequencia;
	            padre.caracter = '-';
	            padre.izq = izq;
	            padre.der = der;
	            cola.add(padre);
	        }

	        //raiz del arbol de Huffman sera el ultimo valor de la cola
	        HuffmanNodo raiz = cola.poll();

	        //generamos los codigos de Huffman
	        CodigoHuffman.generarCodigo(raiz, "");

	        //codificamos el texto
	        String textoCodificado = CodigoHuffman.codificarTexto(texto);

	        //mostramos resultados
	        System.out.println("Texto original: " + texto);
	        System.out.println("Codificación de Huffman: " + textoCodificado);
	        
	        //aprovechamos el objeto de tipo map creado para mostrar los codigos de Huffman para cada carácter
	        System.out.println("\nCódigos de Huffman para cada carácter:");
	        for (Map.Entry<Character, String> entry : CodigoHuffman.huffmanCodigo.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
	        //cerramos el scanner
	        scanner.close();
	    }
	
}
