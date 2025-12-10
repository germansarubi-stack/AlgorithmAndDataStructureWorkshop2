

	//c) Implementar, en el lenguaje de programación Java, el método para evitar las colisiones basado en hashing abierto.
	//Para esto, debes utilizar una lista para almacenar los valores.

import java.util.LinkedList;
public class ColisionesHashingAbierto {
	//arreglo de lista para almacenar los valores y su tamaño
	private LinkedList<Integer>[] tabla;
	private int tamaño;

	public void tablaHashAbierto(int tamaño) {
		//indicamos a la clase que este es el tamaño de la lista 
		this.tamaño = tamaño;
		//creamos un objeto nuevo de formato lista del tamaño indicado
		tabla = new LinkedList[tamaño];
		// con un bucle inicializamos la lista en el arreglo
		for (int i = 0; i < tamaño; i++) {
			tabla[i] = new LinkedList<>();
	    }
	}

	public void insertarValor(int valor) {
		//varibale que llama a nuestra funcion hash con el valor indicado
		int x = FuncionHash.funcionHash(valor);
		//se la agrega a la lista
	    tabla[x].add(valor);
	}

	public boolean buscarValor(int valor) {
		//variable que llama a nuestra funcion hash con el valor indicado
		int x = FuncionHash.funcionHash(valor);
		//retorna true o false si encuentra el valor
	    return tabla[x].contains(x);
	    }

}
