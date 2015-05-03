package business.game.tablero.util.lectores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import play.Play;
import business.game.tablero.nodos.impl.NodoQuesito;
import business.game.tablero.util.ContenedorDeNodos;
import business.game.tablero.util.SelectorDeColores;

public class LectorCircular implements LectorTipoTablero {

	@Override
	public ContenedorDeNodos cargarTablero(String fichero) throws IOException {
		URL file = Play.application().classloader().getResource(fichero);
		BufferedReader BR = new BufferedReader(new FileReader(file.getPath()));
		ContenedorDeNodos contenedor = new ContenedorDeNodos();
		try {
			String linea;
			while ((linea = BR.readLine()) != null) {
				String[] lineas = linea.split(" ");
				for (int i = 0; i < lineas.length; i++) {
					contenedor.getNodosQuesito().add(
							new NodoQuesito(SelectorDeColores.getIstance()
									.getColor(lineas[i])));
				}
			}
		} catch (Exception e) {
		} finally {
			BR.close();
		}
		return contenedor;
	}

}
