package business.serializador;

import business.serializador.impl.Serializador;
/**
 * Factoria del serializador
 * @author Inigo Llaneza Aller
 *
 */
public interface ServiceSerializador {
	/**
	 * Creacion de un Serializador
	 * @return Serializador: Clase
	 */
	Serializador getSerializador();
}
