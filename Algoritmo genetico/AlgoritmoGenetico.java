
public class AlgoritmoGenetico {
	
	//funcion genetica de la sumatoria de los valores del arreglo multiplicado por 2
	public static int funcionGenetica (int[] x) {
		int valor = 0;
		//recorremos el arreglo y por cada posicion multimplicamos su valor por 2 y se suma a una variable
		for (int i=0; i<x.length; i++) {
			valor = valor + (x[i]*2);
		}
		return valor;//devolvemos el valor de la variable con la funcion calculada
	}
	
	//funcion para rellenar el arreglo de 1 o 0 aleatoriamente
	public static int[] aleatorio (int[] vector) {
		//recorremos el arreglo y llamamos a la funcion de random para guardar en cada posicion un valor aleatorio 1 o 0
		for (int i=0; i<vector.length; i++) {
			vector[i] = (int)Math.floor(Math.random()*2);//utilizamos int para pasarlo de decimal a entero 
		}
		return vector;
	}
	
	//funcion que cruza dos vectores devolviendo uno nuevo
	public static int[] cruce (int[] x, int[] y, int tamaño) {
		int resultante[] = new int [tamaño];
		//recorremos el vector y lo valuamos segun la condicion requerida
		for(int i=0; i<resultante.length; i++) {
			if (x[i]==y[i]) {//si el vector primario y secundario contienen el mismo valor en la misma posicion 
				resultante[i]=1;//valua en 1 el nuevo vector resultante
			}else resultante[i]=0;//sino valua en 0
		}
		return resultante;	
	}
	
	
}