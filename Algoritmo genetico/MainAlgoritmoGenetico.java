

public class MainAlgoritmoGenetico {
	public static void main(String[] args) {
		int contador = 0;//cuanta la cantidad de cruces del algoritmo
		int tamaño = 20;//tamaño del los arreglos
		int hx, aux;//variables para guardar los valores de la funcion genetica
		
		//creamos 3 arreglos para el algoritmo
		int [] principal = new int[tamaño];
		int [] secundaria = new int[tamaño];
		int [] resultante = new int[tamaño];
		
		//llenado del arreglo principal con numeros aleatorios para comenzar el arlgoritmo
		AlgoritmoGenetico.aleatorio(principal);
		
		//gurdamos el primer valor de la funcion genetica generado por el arreglo principal que se utiliza como
		//bandera de inicio para los sucesivos cruces
		hx = AlgoritmoGenetico.funcionGenetica(principal);
		
		//creamos un bucle que finalizara al encontrar la solucion optima de la funcion genetica
		//dentro del bucle el arreglo secundario se renovara en cada interaccion para cruzarlo con el primario
		//el algoritmo resultante se transformara en el nuevo primario de ser mas optimo o se simplemente se descartara
		while (hx < 40) {
			AlgoritmoGenetico.aleatorio(secundaria);
			resultante = AlgoritmoGenetico.cruce(principal,secundaria,tamaño);
			contador++;//en cada cruce aumentamos el contador
			aux = AlgoritmoGenetico.funcionGenetica(resultante);//calculamos la funcion genetica del arreglo resultante
			
			//condicional que comprara las funciones geneticas del arreglo primario y resultante
			//de arrojar un mejor valor se guarda en la variable correspondiente y el arreglo resultante se guarda en el
			//principal, se aprovecha el condicional para imprimir por consola los datos mientras vaya 
			//encontrado cadenas mas optimas
			if (aux > hx) {
				hx = aux;
				principal = resultante;
				System.out.print("Cadena apta encontrada en el cruce N° "+contador+":");
				for (int i = 0; i<principal.length; i++) {
					System.out.print("["+principal[i]+"]");
				}
				System.out.println(" H(x)= "+hx);
			}
		}
		
		System.out.println("Algoritmo finalizado con un total de "+contador+" cruces hasta llegar a la solucion optima");
		for (int i = 0; i<principal.length; i++) {
			System.out.print("["+principal[i]+"]");
		}
		System.out.println(" H(x)= "+hx);
	}
}
