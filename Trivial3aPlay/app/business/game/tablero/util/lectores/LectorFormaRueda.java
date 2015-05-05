package business.game.tablero.util.lectores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import business.game.tablero.nodos.impl.NodoNormal;
import business.game.tablero.nodos.impl.NodoQuesito;
import business.game.tablero.util.ContenedorDeNodos;
import business.game.tablero.util.SelectorDeColores;

public class LectorFormaRueda implements LectorTipoTablero{

	
	// lee del fichero txt y va metiendo cada nodo en el array correspondiente
	public ContenedorDeNodos cargarTablero(String fichero) throws IOException {
		BufferedReader BR = new BufferedReader(new FileReader(fichero));
		ContenedorDeNodos contenedor = new ContenedorDeNodos();
//		try {
//			String linea;
//			while ((linea = BR.readLine()) != null) {
//				String[] lineas = linea.split("-");
//				contenedor.getNodosQuesito().add(
//						new NodoQuesito(SelectorDeColores.getIstance()
//								.getColor(lineas[0])));
//				String[] lineas2 = lineas[1].split(" ");
//				for (String s : lineas2)
//					contenedor.getNodosExteriores().add(
//							new NodoNormal(SelectorDeColores.getIstance()
//									.getColor(s)));
//				String[] lineas3 = lineas[2].split(" ");
//				for (String s : lineas3)
//					contenedor.getNodosInteriores().add(
//							new NodoNormal(SelectorDeColores.getIstance()
//									.getColor(s)));
//			}
//		} catch (Exception e) {
//		} finally {
//			BR.close();
//		}
		return contenedor;
	}
}
