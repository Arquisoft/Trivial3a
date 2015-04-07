package presentacion.login.impl;

import javax.swing.table.*;

public class ModeloNoEditable extends DefaultTableModel{

	private static final long serialVersionUID = 1L;
	
	public ModeloNoEditable(Object[] nombreColumna, int contarFila){
		super(nombreColumna, contarFila);
	}
	
	@Override
	public boolean isCellEditable(int fila, int columna) {
        return false;
    }

}
