package business.game.tablero.util;

import java.util.ArrayList;

import business.game.tablero.nodos.impl.NodoNormal;
import business.game.tablero.nodos.impl.NodoQuesito;

//Es una especie de adapter, para tener mejor controlados los tipos de nodos
public class ContenedorDeNodos {
	private ArrayList<NodoNormal> nodosExteriores = new ArrayList<NodoNormal>();
	private ArrayList<NodoNormal> nodosInteriores = new ArrayList<NodoNormal>();
	private ArrayList<NodoQuesito> nodosQuesito = new ArrayList<NodoQuesito>();
	public ArrayList<NodoNormal> getNodosExteriores() {
		return nodosExteriores;
	}
	public void setNodosExteriores(ArrayList<NodoNormal> nodosExteriores) {
		this.nodosExteriores = nodosExteriores;
	}
	public ArrayList<NodoNormal> getNodosInteriores() {
		return nodosInteriores;
	}
	public void setNodosInteriores(ArrayList<NodoNormal> nodosInteriores) {
		this.nodosInteriores = nodosInteriores;
	}
	public ArrayList<NodoQuesito> getNodosQuesito() {
		return nodosQuesito;
	}
	public void setNodosQuesito(ArrayList<NodoQuesito> nodosQuesito) {
		this.nodosQuesito = nodosQuesito;
	}

	

}
