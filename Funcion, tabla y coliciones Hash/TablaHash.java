

	//d) Implementar un algoritmo en lenguaje Java donde utilices los métodos de insertar, buscar y eliminar valores
	//dentro de la tabla hash que permita elegir el método deseado para manejar las colisiones.

import java.util.ArrayList;
import java.util.Arrays;
public class TablaHash {
		
		//creamos variable dentro de la clase para cada metodo de manejo de colisiones
	    private int[] tablaLineal;//array para el metodo lineal
	    private int[] tablaCuadratica;//array para el metodo cuadratico
	    private ArrayList<Integer>[] tablaAbierta;//lista de arreglos para el metodo hash abierto
	    private int tamaño;//tamaño que se desea la tabla

	    //metodo para inicializar en vacio = 0 todas las tablas y la lista
	    public void tablaHash(int tamaño) {
	        this.tamaño = tamaño;
	        tablaLineal = new int[tamaño];
	        tablaCuadratica = new int[tamaño];
	        tablaAbierta = new ArrayList[tamaño];
	        Arrays.fill(tablaLineal, 0);
	        Arrays.fill(tablaCuadratica, 0);
	        for (int i = 0; i < tamaño; i++) {
	            tablaAbierta[i] = new ArrayList<>();
	        }
	    }

	    //metodo insertar dependiendo la funcion elegida para controlar las colisiones
	    public void insertar(int valor, String metodo) {
	    	
	    	//creamos un condicional para usar el metodo elegido por el usuario
	    	//metodo lineal 
	        if (metodo.equals("lineal")) {
	        	//llamamos a la funcion hash
	            int hash = FuncionHash.funcionHash(valor);
	            //buscamos la posicion de forma lineal para insertar el valor
	            while (tablaLineal[hash] !=0 ) {
	                hash = FuncionHash.funcionHash(valor+1); // Sondeo lineal
	            }
	            tablaLineal[hash] = valor;
	           
	          //metodo cuadratico
	        } else if (metodo.equals("cuadratico")) {
	        	//llamada a funcion hash
	            int hash = FuncionHash.funcionHash(valor);
	            //variable para lograr el valor elevado al cuadrado
	            int i = 0;
	            //busqueda de posicion cuadratica para insertar el valor
	            while (tablaCuadratica[hash] != 0) {
	                i++;
	                hash = FuncionHash.funcionHash(valor+(i*i)); // Sondeo cuadrático
	            }
	            tablaCuadratica[hash] = valor;
	            
	         //metodo hash abierto   
	        } else if (metodo.equals("abierto")) {
	        	//llamamos a funcion hash
	            int hash = FuncionHash.funcionHash(valor);
	            //agregamos a la cola de la tabla
	            tablaAbierta[hash].add(valor);
	        }
	    }

	    //metodo buscar dependiendo la funcion elegida para controlar las colisiones
	    public boolean buscar(int valor, String metodo) {
	    	//buscar lineal
	        if (metodo.equals("lineal")) {
	            int hash = FuncionHash.funcionHash(valor);
	            //mientras la pocision no este vacia = 0, sigue buscando 
	            while (tablaLineal[hash] != 0) {
	            	//si encuentra el valor retorna true
	                if (tablaLineal[hash] == valor) {
	                    return true; 
	                }
	                hash = FuncionHash.funcionHash(valor+1);//busqueda lineal
	            }
	            
	            //buscar cuadratico
	        } else if (metodo.equals("cuadratico")) {
	            int hash = FuncionHash.funcionHash(valor);
	            int i = 0;
	            while (tablaCuadratica[hash] != 0) {
	                if (tablaCuadratica[hash] == valor) {
	                    return true;
	                }
	                i++;
	                hash = FuncionHash.funcionHash(valor+(i*i)); //busqueda cuadratica
	            }
	            
	            //buscar hash abierto
	        } else if (metodo.equals("abierto")) {
	            int hash = FuncionHash.funcionHash(valor);
	            //busca en la tabla si encuentra el valor retorna true
	            return tablaAbierta[hash].contains(valor);
	        }
	        //si termina cualqueira de los metodos y no ecneuntra el valor retorna false
	        return false;
	    }

	    
	  //metodo eliminar dependiendo la funcion elegida para controlar las colisiones
	    public void eliminar(int valor, String metodo) {
	    	//eliminar lineal
	        if (metodo.equals("lineal")) {
	            int hash = FuncionHash.funcionHash(valor);
	            //bucle mientras la posicion no sea vacio = 0 buscara linealmente
	            while (tablaLineal[hash] != 0) {
	            	//condicional que evalua en la posicion si es igual al valor enviado
	                if (tablaLineal[hash] == valor) {
	                	//si el condicional es verdadero elimina el valor en la posicion
	                    tablaLineal[hash] = 0;
	                    return;
	                }
	                hash = FuncionHash.funcionHash(valor+1);//sondeo lineal
	            }
	            
	            //eliminar cuadratico
	        } else if (metodo.equals("quadratic")) {
	            int hash = FuncionHash.funcionHash(valor);
	            int i = 0;
	            while (tablaCuadratica[hash] != 0) {
	                if (tablaCuadratica[hash] == valor) {
	                    tablaCuadratica[hash] = 0;
	                    return;
	                }
	                i++;
	                hash = FuncionHash.funcionHash(valor+(i*i));//sondeo cuadratico
	            }
	            
	            //eliminar hash abierto
	        } else if (metodo.equals("abierta")) {
	            int hash = FuncionHash.funcionHash(valor);
	            //busca en la tabla y remueve el valor enviado
	            tablaAbierta[hash].remove((Integer) valor);
	        }
	    }	
}
