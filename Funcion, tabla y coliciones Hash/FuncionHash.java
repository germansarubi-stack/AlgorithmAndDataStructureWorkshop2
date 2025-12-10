
	//a) Implementar, en el lenguaje de programación Java, la siguiente función hash H(x) = X mod 10, 
	//la cual determinará el índice donde almacenar el valor en la tabla.
	
public class FuncionHash {
	
	int dato;
	int estado; //0 = Vacio, 1 = Eliminado, 2 = Ocupado
	
	static int funcionHash(int n) {
		//n es el valor enviado como parametro 
		return n%10; // H(x)= X mod 10
	}
	
	public static void iniciarVaciarTabla(FuncionHash[] tabla, int tamaño) {
		int i;
		//creamos un ciclo que ponga estado vacio en toda la tabla hash
		for (i = 0; i < tamaño; i++) {
			tabla[i] = new FuncionHash();
			tabla[i].estado = 0;
		}
			
		
	}
	
	//b) Implementar, en el lenguaje de programación Java, los siguientes métodos para manejar las colisiones: 
	//Sondeo lineal.
	//Sondeo cuadrático. 
	
	
	public void sondeoLineal(FuncionHash[] tabla, int valor) {
		//variable que llama a la funcion hash
		int x = funcionHash(valor);
		//bucle que busca linealmente donde guardar el valor en la tabla
		while (tabla[x].estado!=0) {
			x = funcionHash(valor+1) ;//sondeo lineal
		}
		tabla[x].dato=valor;//guardamos el valor en la posicion que corresponde al sondeo lineal
		tabla[x].estado=2;//actualizamos el estado a ocupado
	}
		
		
	public boolean buscarLineal(FuncionHash[] tabla,int valor) {
		int x = funcionHash(valor);
	    while (tabla[x].estado != 0) {
	    	if (tabla[x].dato == valor) {
	    		return true;
	        }
	        x =funcionHash(valor+1) ;
	    }
	    return false;
	}
	
	
	public void sondeoCuadratico(FuncionHash[] tabla, int valor) {
		//variable que llama a la funcion hash
		int x = funcionHash(valor);
		//iniciamos varibale para calcular el sondeo cuadratico
		int i = 0;
		//bucle que busca linealmente donde guardar el valor en la tabla
		while (tabla[x].estado!=0) {
			i++;
			x = funcionHash(valor+(i*i)) ;//sondeo cuadratico
		}
		tabla[x].dato=valor;//guardamos el valor en la posicion que corresponde al sondeo lineal
		tabla[x].estado=2;//actualizamos el estado a ocupado
	}

	public boolean buscarCuadratico(FuncionHash[] tabla,int valor) {
		int x = funcionHash(valor);
		int i = 0;
	    while (tabla[x].estado != 0) {
	    	if (tabla[x].dato == valor) {
	    		return true;
	        }
	        x =funcionHash(valor+(i*i)) ;
	    }
	    return false;
	}
}

