package presentacion.login;

import presentacion.login.impl.FondoLogin;
import presentacion.login.impl.VentanaLogin;
import presentacion.login.impl.VentanaRegistro;

public interface PresentationLogin {
	
	FondoLogin getFondoLogin();
	
	VentanaLogin getVentanaLogin();
	
	VentanaRegistro getVentanaRegistro(VentanaLogin vl);
}
