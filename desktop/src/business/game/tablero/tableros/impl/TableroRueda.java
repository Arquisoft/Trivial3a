package business.game.tablero.tableros.impl;

import java.io.IOException;

import business.game.tablero.nodos.Nodo;
import business.game.tablero.nodos.impl.NodoFinal;
import business.game.tablero.nodos.impl.NodoQuesito;
import business.game.tablero.tableros.Tablero;
import business.game.tablero.util.ContenedorDeNodos;
import business.game.tablero.util.lectores.LectorFormaRueda;
import business.game.tablero.util.lectores.LectorTipoTablero;

//Est�n insertados en el sentido de las agujas del reloj
public class TableroRueda implements Tablero{
	// el primero de todos para no perder la referencia
	private Nodo raiz;
	// el pivote
	private Nodo aux;
	// el contenedor en el que tenemos todos los datos de todos los nodos que
	// vamos a enlazar
	private ContenedorDeNodos cn;
	// selector de tableros por defecto en forma de rueda
	private LectorTipoTablero ltt = new LectorFormaRueda();

	public TableroRueda(int tam) {
		int contadorDeExteriores = 0;
		int contadorDeInteriores = 0;
		NodoFinal fnl = new NodoFinal(tam);
		try {
			cn = ltt.cargarTablero("tablero.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// pillamos un nodo con quesito y partimos de �l
		raiz = aux = cn.getNodosQuesito().get(0);

		for (int j = 0; j < tam; j++) {
			Nodo aux2 = aux;
			// el primero de cada quesito lo enlazamos en su nodo hacia arriba
			((NodoQuesito) aux2).setArriba(cn.getNodosInteriores().get(
					contadorDeInteriores));
			cn.getNodosInteriores().get(contadorDeInteriores).setAnterior(aux2);
			aux2 = cn.getNodosInteriores().get(contadorDeInteriores);
			contadorDeInteriores++;
			// le enlazamos los 5 correspondientes hacia arriba y el final
			for (int i = 1; i < tam - 1; i++) {
				aux2.setSiguiente(cn.getNodosInteriores().get(
						contadorDeInteriores));
				cn.getNodosInteriores().get(contadorDeInteriores)
						.setAnterior(aux2);
				aux2 = cn.getNodosInteriores().get(contadorDeInteriores);
				contadorDeInteriores++;
			}
			aux2.setSiguiente(fnl);
			fnl.getN()[j] = aux2;
			// le enlazamos los 6 siguientes en el sentodop de las agujas del
			// reloj
			for (int i = 0; i < tam; i++) {
				aux.setSiguiente(cn.getNodosExteriores().get(
						contadorDeExteriores));
				cn.getNodosExteriores().get(contadorDeExteriores)
						.setAnterior(aux);
				aux = cn.getNodosExteriores().get(contadorDeExteriores);
				contadorDeExteriores++;
			}
			// enlazamos con el sigueinte nodo con quesito
			if ((j + 1) != tam) {
				aux.setSiguiente(cn.getNodosQuesito().get(j + 1));
				cn.getNodosQuesito().get(j + 1).setAnterior(aux);
				aux = cn.getNodosQuesito().get(j + 1);

			} else {
				// ultima iteracion
				aux.setSiguiente(raiz);
				raiz.setAnterior(aux);
				aux = raiz;
			}
		}
	}

	public void print() {
		do {
			// System.out.println(aux.getSiguiente());
			if (aux instanceof NodoQuesito)
				printInteriores((NodoQuesito) aux);
			aux = aux.getSiguiente();
		} while (aux != raiz);
		aux = raiz;
	}

	public void printInteriores(NodoQuesito n) {
		Nodo aux2 = aux;
		System.out.println(n);
		aux2 = n.getArriba();
		while (!(aux2 instanceof NodoFinal)) {
			System.out.println(aux2);
			aux2 = aux2.getSiguiente();
		}
	}

	@Override
	public Nodo getReferencia() {
		// TODO Auto-generated method stub
		return raiz;
	}
}
