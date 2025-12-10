
import java.util.Comparator;//para comparar y ordenar listas
import java.util.Map;//para almacenar elementos en pares clave-valor
import java.util.HashMap;//utilozamos en conjunto con el map para que no tengan orden especifico y no acepte duplicados ni nulos


//comparador para la cola de prioridades   
//compara los nodos 
class comparadorDeFrecuencia implements Comparator<HuffmanNodo> {
	public int compare(HuffmanNodo x, HuffmanNodo y) {
		return x.frequencia - y.frequencia;
	}
}

public class CodigoHuffman {
	
	//creamos un mapeo de clave-valor para asignar a cada clave un valor y asi cuando sea necesario 
	//se recupera los valores con las claves correspondientes 
	public static Map<Character, String> huffmanCodigo = new HashMap<>();
    
    //generamos los codigos de Huffman recursivamente
    public static void generarCodigo(HuffmanNodo raiz, String codigo) {
        if (raiz == null) return;//corte de la recursividad

        //si es una hoja guarda el código
        if (raiz.izq == null && raiz.der == null) {
            huffmanCodigo.put(raiz.caracter, codigo);//agrega a la cola
        }
        
        //seguimos llamando recursivamente agregandole 0 y 1 respectivamente cuando va descendiendo en el arbol
        //lo que cumple con la teoria de codigos mas largos para caracteres menos freceuntes
        generarCodigo(raiz.izq, codigo + "0");
        generarCodigo(raiz.der, codigo + "1");
    }

    //metodo para codificar el texto usando los códigos de Huffman generados
    public static String codificarTexto(String texto) {
    	//utilizamos stringbuilder para manipular la cadena sin cerar un objeto
    	//tomamor caracter por caracter y obtenemos su transformacion huffman para guardarlo en la variable codificarString
        StringBuilder codificarString = new StringBuilder();
        for (char c : texto.toCharArray()) {
            codificarString.append(huffmanCodigo.get(c));
        }
        return codificarString.toString();//retornamos la variable con el texto codificado huffman en bytes
    }
}

