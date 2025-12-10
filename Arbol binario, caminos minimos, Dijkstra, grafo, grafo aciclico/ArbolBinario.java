
import java.io.*;

	//Definición de la clase NodoBinario
	class NodoBinario{
		String dato;
		int distancia;
		NodoBinario Hizq, Hder;
		//Constructor
		NodoBinario (String Elem, int dist){
			// Datos a almacenar
			dato = Elem;
			distancia = dist;
			//Definición de hijos
			NodoBinario Hizq, Hder = null;
		}
	}

	//Definición de la clase Arbol
	class Arbol{
		NodoBinario Padre;
		public NodoBinario Raiz;
		//Constructor
		public Arbol(){
			Raiz = null;
		}
		//Se codificaron 2 métodos y en caso de que el nodo padre de
		//referencia sea nulo se asume que es la raíz
		
		//Inserción de un hijo izquierdo
		public NodoBinario InsertaNodoHIzq(NodoBinario Nodo, String Elem, int dist){
			NodoBinario result=null;
			String Elemento = new String(Elem);
			if (Nodo==null) {
				NodoBinario NodoAux = new NodoBinario (Elem, dist);
				result=NodoAux;
				Raiz=NodoAux;
			} else {
				if(Nodo.Hizq == null) {
					NodoBinario NodoAux = new NodoBinario (Elem, dist);
					Nodo.Hizq=NodoAux;
					result=NodoAux;
				}
				else
					System.out.print ("ERR- Hijo izquierdo de "+
							Elemento.toString() +" no es nulo");
			}
			return result;
		}
	
	
		//Inserción de un hijo derecho
		public NodoBinario InsertaNodoHDer(NodoBinario Nodo, String Elem, int dist){
			NodoBinario result=null;
			String Elemento = new String(Elem);
			if (Nodo==null) {
				NodoBinario NodoAux = new NodoBinario (Elem, dist);
				result=NodoAux;
				Raiz=NodoAux;
			} else {
				if(Nodo.Hder == null) {
					NodoBinario NodoAux = new NodoBinario (Elem, dist);
					Nodo.Hder=NodoAux;
					result=NodoAux;
				}
				else
					System.out.print ("ERR- Hijo Derecho de "+
							Elemento.toString() +" no es nulo");
			}
			return result;
		}
		
		//Recorrido InOrder de manera recursiva,
		//Al ser Inodern se recorre el arbol primero por los hijos izquierdos 
		//Luego la raiz y por ultimos los hijos derechos
		public void Inorden (NodoBinario Nodo){
			if (Nodo == null) // Caso base para cortar la recursividad
				return;
			else {
				Inorden (Nodo.Hizq);
				System.out.print("["+Nodo.dato+"]");
				Inorden (Nodo.Hder);
			}
		}
		//Altura del arbol
		public int Altura (NodoBinario Nodo){
			if (Nodo == null) { //Caso base para cortar la recursividad
				return -1;
			}else return 1+ Math.max(Altura(Nodo.Hizq), Altura(Nodo.Hder));// elige el maximo
			//entre la altura izquierda y la altura derecha y le suma 1
		}
	}
	

		class ArbolBinario{
		public static void main(String[] ar) {
			Arbol A = new Arbol();
			
			NodoBinario
			NodoAux=null,NodoAux2=null,NodoAux3=null,NodoAux4=null;
			NodoAux2=A.InsertaNodoHIzq(NodoAux,"d1", 0);
			NodoAux=NodoAux2;
			NodoAux2=A.InsertaNodoHIzq(NodoAux,"d9", 290);
			NodoAux3=A.InsertaNodoHDer(NodoAux, "d13",250);
			NodoAux=NodoAux2;
			NodoAux2=A.InsertaNodoHIzq(NodoAux,"d8",220);
			NodoAux4=A.InsertaNodoHDer(NodoAux,"d12",100);
			System.out.print("\n El árbol binario en In orden es: \n");
			A.Inorden (A.Raiz);
			Integer Altura = new Integer(A.Altura (A.Raiz));
			System.out.print("\n La altura del árbol es: "+
			Altura.toString() +"\n");
			}
		
		}

