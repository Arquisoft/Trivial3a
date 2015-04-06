package business.game.tablero.logic.nodos;

//nodo �ltimo que posee las 6-7-n entradas 
public class NodoFinal implements Nodo {
	private Nodo[] n;

	public NodoFinal(int tam) {
		n = new Nodo[tam];
	}

	public NodoFinal(Nodo[] n) {
		super();
		this.n = n;
	}

	@Override
	public Nodo getSiguiente() {
		// TODO Auto-generated method stub
		return null;
	}

	public Nodo[] getN() {
		return n;
	}

	public void setN(Nodo[] n) {
		this.n = n;
	}

	@Override
	public Nodo getAnterior() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSiguiente(Nodo siguiente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAnterior(Nodo anterior) {
		// TODO Auto-generated method stub
		
	}

}
