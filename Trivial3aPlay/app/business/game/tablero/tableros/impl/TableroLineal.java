package business.game.tablero.tableros.impl;

import java.io.IOException;

import business.game.tablero.nodos.Nodo;
import business.game.tablero.tableros.Tablero;
import business.game.tablero.util.ContenedorDeNodos;
import business.game.tablero.util.lectores.LectorCircular;
import business.game.tablero.util.lectores.LectorTipoTablero;

public class TableroLineal implements Tablero {

	// el primero de todos para no perder la referencia
	private Nodo raiz;
	// el pivote
	private Nodo aux;
	// el contenedor en el que tenemos todos los datos de todos los nodos que
	// vamos a enlazar
	private ContenedorDeNodos cn;
	// selector de tableros por defecto en forma de rueda
	private LectorTipoTablero ltt = new LectorCircular();

	public TableroLineal() {
		try {
			cn = ltt.cargarTablero("circular.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// pillamos un nodo con quesito y partimos de �l
		raiz = aux = cn.getNodosQuesito().get(0);
		// enlazamos los extremos
		raiz.setSiguiente(cn.getNodosQuesito().get(1));
		cn.getNodosQuesito().get(1).setAnterior(raiz);
		cn.getNodosQuesito()
				.get(cn.getNodosQuesito().size() - 1)
				.setAnterior(
						cn.getNodosQuesito().get(
								cn.getNodosQuesito().size() - 2));
		aux = cn.getNodosQuesito().get(1);
		// enlazamos circularmente
		for (int i = 1; i < cn.getNodosQuesito().size() - 1; i++) {
			aux.setAnterior(cn.getNodosQuesito().get(i - 1));
			aux.setSiguiente(cn.getNodosQuesito().get(i + 1));
			aux = cn.getNodosQuesito().get(i + 1);
		}
		raiz.setAnterior(null);

	}

	@Override
	public Nodo getReferencia() {
		return raiz;
	}

	@Override
	public int getTamano() {
		return 6;
	}
}