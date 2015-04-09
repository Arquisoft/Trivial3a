package business.core.impl;

import presentacion.login.impl.VentanaLogin;
import business.core.Core;
import business.herramientas.extractor.impl.Extractor;

public class ExtractorLauncher implements Core {

	@Override
	public void run() {
		Extractor extractor = new Extractor();
		extractor.run();
	}

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

}
