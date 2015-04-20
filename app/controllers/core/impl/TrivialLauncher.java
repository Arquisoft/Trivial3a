package business.core.impl;

import presentacion.login.impl.VentanaLogin;
import business.core.Core;
import business.herramientas.extractor.impl.Extractor;

public class TrivialLauncher implements Core {

	@Override
	public void run() {
		VentanaLogin v = new VentanaLogin();
		v.setVisible(true);
		System.out.println("//");

	}

	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

}
